package com.IndustrialesComunes.HabiTech.Controllers;

import com.IndustrialesComunes.HabiTech.Models.ComprobanteEntity;
import com.IndustrialesComunes.HabiTech.Models.DeudaEntity;
import com.IndustrialesComunes.HabiTech.Models.OrdenPagoEntity;
import com.IndustrialesComunes.HabiTech.repositories.ComprobanteRepository;
import com.IndustrialesComunes.HabiTech.repositories.DeudaRepository;
import com.IndustrialesComunes.HabiTech.repositories.OrdenPagoRepository;
import com.IndustrialesComunes.HabiTech.repositories.UserRepository;
import com.IndustrialesComunes.HabiTech.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('RESIDENTE') or hasRole('GADMIN') or hasRole('SADMIN')")
public class residenteController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeudaRepository deudaRepository;

    @Autowired
    OrdenPagoRepository ordenPagoRepository;

    @Autowired
    ComprobanteRepository comprobanteRepository;

    @GetMapping("/deudaActual")
    public ResponseEntity<?> getDeudaActual(@RequestHeader("Authorization") String tokenHeader){
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            String token = tokenHeader.substring(7);
            if (jwtUtils.isTokenValid(token)) {
                String username = jwtUtils.getUsernameFromToken(token);

                List<DeudaEntity> deudas = deudaRepository.findAllByResidenteUsername(username);

                List<DeudaEntity> deudaVigente = new ArrayList<>();
                if(!deudas.isEmpty()){
                    for(DeudaEntity deuda : deudas){
                        if(!deuda.getPagado()  &&  deuda.getFechaInicio().isBefore( LocalDate.now() )){
                            deudaVigente.add(deuda);
                        }
                    }
                }
                return ResponseEntity.ok(deudaVigente);
            }
        }
        return ResponseEntity.badRequest().body("Requiere haber una sesion activa para obtener la deuda del usuario");
    }

    @GetMapping("/montoActual")
    public ResponseEntity<?> getMontoActual(@RequestHeader("Authorization") String tokenHeader){
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            String token = tokenHeader.substring(7);
            if (jwtUtils.isTokenValid(token)) {
                String username = jwtUtils.getUsernameFromToken(token);

                List<DeudaEntity> deudas = deudaRepository.findAllByResidenteUsername(username);

                double amount = 0;

                if(!deudas.isEmpty()){
                    for(DeudaEntity deuda : deudas){
                        if(!deuda.getPagado()  &&  deuda.getFechaInicio().isBefore( LocalDate.now())){
                            amount += deuda.getValue();
                        }
                    }
                }
                return ResponseEntity.ok(amount);
            }
        }
        return ResponseEntity.badRequest().body("Requiere haber una sesion activa para obtener la deuda del usuario");
    }

    @GetMapping("/comprobantes")
    public ResponseEntity<?> getComprobantes(@RequestHeader("Authorization") String tokenHeader){
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            String token = tokenHeader.substring(7);
            if (jwtUtils.isTokenValid(token)) {
                String username = jwtUtils.getUsernameFromToken(token);
                return ResponseEntity.ok( comprobanteRepository.findAllByResidenteUsername(username) );
            }
        }
        return ResponseEntity.badRequest().body("Requiere haber una sesion activa para obtener la deuda del usuario");
    }

    @PostMapping("/pagar")
    public ResponseEntity<?> pagar(@RequestHeader("Authorization") String tokenHeader) {
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            String token = tokenHeader.substring(7);
            if (jwtUtils.isTokenValid(token)) {
                String username = jwtUtils.getUsernameFromToken(token);
                List<DeudaEntity> deudas = deudaRepository.findAllByResidenteUsername(username);

                List<DeudaEntity> deudaVigente = new ArrayList<>();

                double amount = 0;
                if(!deudas.isEmpty()){
                    for(DeudaEntity deuda : deudas){
                        if(!deuda.getPagado()  &&  deuda.getFechaInicio().isBefore( LocalDate.now())){
                            amount += deuda.getValue();
                            deudaVigente.add(deuda);
                        }
                    }
                    // Por simplicidad del ejemplo se unen las orden de pago
                    // Con la generacion del comprobante, pero esta orden deberia mandar
                    // A otra web donde se realice el pago y cuando se vuelve con un
                    // Token, generar el comprobante
                    OrdenPagoEntity ordenPago = OrdenPagoEntity.builder()
                            .value(amount)
                            .medioPago("Webpay")
                            .deudasAsociadas(deudaVigente)
                            .build();

                    ordenPagoRepository.save(ordenPago);

                    ComprobanteEntity comprobante = ComprobanteEntity.builder()
                            .valor(ordenPago.getValue())
                            .ordenPago(ordenPago)
                            .residente( userRepository.findByUsername(username).orElseThrow() )
                            .fechaPago( LocalDate.now() )
                            .build();

                    comprobanteRepository.save(comprobante);

                    for( DeudaEntity deuda : comprobante.getOrdenPago().getDeudasAsociadas() ){
                        deuda.setPagado(true);
                        deudaRepository.save(deuda);
                    }

                    return ResponseEntity.ok(comprobante);

                }
                return ResponseEntity.badRequest().body("El usuario no posee deudas");
            }
        }
        return ResponseEntity.badRequest().body("Requiere haber una sesion activa para obtener la deuda del usuario");
    }
}
