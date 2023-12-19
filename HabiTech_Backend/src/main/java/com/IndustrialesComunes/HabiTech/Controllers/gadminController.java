package com.IndustrialesComunes.HabiTech.Controllers;


import com.IndustrialesComunes.HabiTech.Controllers.request.*;
import com.IndustrialesComunes.HabiTech.Models.*;
import com.IndustrialesComunes.HabiTech.repositories.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/gadmin")
@PreAuthorize("hasRole('GADMIN')")
public class gadminController {

    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    UnidadRepository unidadRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ExtraUnidadRepository extraUnidadRepository;

    @Autowired
    GastoComunRepository gastoComunRepository;

    @Autowired
    DeudaRepository deudaRepository;


    @GetMapping("/usuarios")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/community")
    public ResponseEntity<?> getCommunities(){
        return ResponseEntity.ok(communityRepository.findAll());
    }

    @GetMapping("/buildings")
    public ResponseEntity<?> getBuildings(){
        return ResponseEntity.ok(buildingRepository.findAll());
    }

    @GetMapping("/unidades")
    public ResponseEntity<?> getUnidades(){
        return ResponseEntity.ok(unidadRepository.findAll());
    }

    @GetMapping("/unidadesExtra")
    public ResponseEntity<?> getUnidadesExtra(){
        return ResponseEntity.ok(extraUnidadRepository.findAll());
    }

    @GetMapping("/gastosComunes")
    public ResponseEntity<?> getGastosComunes(){
        return ResponseEntity.ok(gastoComunRepository.findAll());
    }

    @GetMapping("/deudas")
    public ResponseEntity<?> getDeudas(){
        return ResponseEntity.ok(deudaRepository.findAll());
    }

    @PostMapping("/createComunnity")
    public ResponseEntity<?> createCommunity(@Valid @RequestBody CreateCommunityDTO createCommunityDTO){
        CommunityEntity communityEntity = CommunityEntity.builder()
                .name(createCommunityDTO.getName())
                .ubication(createCommunityDTO.getUbication())
                .build();
        communityRepository.save(communityEntity);
        return ResponseEntity.ok(communityEntity);
    }

    @PostMapping("/createBuilding")
    public ResponseEntity<?> createBuilding(@Valid @RequestBody CreateBuildingDTO createBuildingDTO){
        BuildingEntity buildingEntity = BuildingEntity.builder()
                .name(createBuildingDTO.getName())
                .ubication(createBuildingDTO.getUbication())
                .community(communityRepository.findById(createBuildingDTO.getId_com()).orElseThrow())
                .build();
        buildingEntity.getCommunity().setNOfBuilds(buildingEntity.getCommunity().getNOfBuilds() + 1);
        buildingRepository.save(buildingEntity);
        return ResponseEntity.ok(buildingEntity);
    }

    @PostMapping("/createUnidad")
    public ResponseEntity<?> createUnidad(@Valid @RequestBody CreateUnidadDTO createUnidadDTO){
        UnidadEntity unidadEntity = UnidadEntity.builder()
                .name(createUnidadDTO.getName())
                .ubication(createUnidadDTO.getUbication())
                .residente( userRepository.findById(createUnidadDTO.getResidenteID()).orElseThrow() )
                .edificio( buildingRepository.findById(createUnidadDTO.getEdificioID()).orElseThrow() )
                .m2( createUnidadDTO.getM2soloUnidad() )
                .build();
        unidadEntity.getEdificio().setNOfUnits(unidadEntity.getEdificio().getNOfUnits() + 1);
        unidadRepository.save(unidadEntity);
        updatePro(unidadEntity.getEdificio());
        return ResponseEntity.ok(unidadEntity);
    }

    @PostMapping("/addExtraUnidad")
    public ResponseEntity<?> addExtraUnidad(@Valid @RequestBody CreateUnidadExtraDTO createUnidadExtraDTO){
        ExtraUnidadEntity extraUnidadEntity = ExtraUnidadEntity.builder()
                .m2e(createUnidadExtraDTO.getM2())
                .type(createUnidadExtraDTO.getType())
                .unidad(unidadRepository.findById( createUnidadExtraDTO.getUnidadID() ).orElseThrow())
                .build();
        extraUnidadRepository.save(extraUnidadEntity);
        updatePro(extraUnidadEntity.getUnidad().getEdificio());
        return ResponseEntity.ok(extraUnidadEntity);
    }

    private void updatePro(BuildingEntity building){
        float totalM2 = 0;
        for(UnidadEntity unidad : building.getUnidades()){
            totalM2 += unidad.getTotalM2();
        }

        building.setM2( (int) totalM2 );

        for(UnidadEntity unidad : building.getUnidades()){
            float pro = unidad.getTotalM2() / totalM2;
            unidad.setProrrateo(pro);
        }

        buildingRepository.save(building);
    }


    @PostMapping("/createGastoComun")
    public ResponseEntity<?> createGastoComun(@Valid @RequestBody CreateGastoComunDTO createGastoComunDTO){
        GastoComunEntity gastoComunEntity = GastoComunEntity.builder()
                .type(createGastoComunDTO.getType())
                .description(createGastoComunDTO.getDescription())
                .total(createGastoComunDTO.getTotal())
                .cuotas(createGastoComunDTO.getCuotas())
                .fecha(LocalDate.now()) // cuando lo crea se pone la fecha actual
                .edificio( buildingRepository.findById(createGastoComunDTO.getEdificioID()).orElseThrow() )
                .build();
        gastoComunRepository.save(gastoComunEntity);
        generarDeudas(gastoComunEntity);
        return ResponseEntity.ok(gastoComunEntity);
    }

    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //        LocalDate.parse(fechaInicio,formatter)

    private void generarDeudas( GastoComunEntity gastoComun ){

        LocalDate fechaActual = gastoComun.getFecha().minusMonths(1).minusDays(1) ; // Para hacer las pruebas
        double Dtotal = gastoComun.getTotal();

        for(int i = 0; i < gastoComun.getCuotas(); i++){
            for (UnidadEntity unidad : gastoComun.getEdificio().getUnidades()){
                DeudaEntity deuda = DeudaEntity.builder()
                        .pagado(false)
                        .value( (Dtotal*unidad.getProrrateo()) / gastoComun.getCuotas())
                        .cuota(i+1)
                        .fechaInicio(fechaActual.plusMonths(i))
                        .fechaTermino(fechaActual.plusMonths(i + 1))
                        .residente(unidad.getResidente())
                        .build();
                deudaRepository.save(deuda);
            }
        }
    }

}