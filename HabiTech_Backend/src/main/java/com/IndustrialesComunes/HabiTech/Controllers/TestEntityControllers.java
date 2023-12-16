package com.IndustrialesComunes.HabiTech.Controllers;

import com.IndustrialesComunes.HabiTech.Controllers.request.SendMessageDTO;
import com.IndustrialesComunes.HabiTech.Models.MessageEntity;
import com.IndustrialesComunes.HabiTech.repositories.MessageRepository;
import com.IndustrialesComunes.HabiTech.repositories.UserRepository;
import com.IndustrialesComunes.HabiTech.security.jwt.JwtUtils;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/test")
public class TestEntityControllers{

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @PostMapping("/sendMessage")
    public ResponseEntity<?> enviarMensaje(@RequestHeader("Authorization") String tokenHeader, @RequestBody SendMessageDTO sendMessageDTO){
        if(tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            String token = tokenHeader.substring(7);
            if (jwtUtils.isTokenValid(token)) {
                String username = jwtUtils.getUsernameFromToken(token);
                MessageEntity messageEntity = MessageEntity.builder()
                        .sender(userRepository.findByUsername(username).orElseThrow())
                        .receiver(userRepository.findById(sendMessageDTO.getReceiverID()).orElseThrow())
                        .message(sendMessageDTO.getMessage())
                        .build();
                messageRepository.save(messageEntity);
                return ResponseEntity.ok(messageEntity);
            }
        }
        return ResponseEntity.badRequest().body("Requiere haber una sesion activa para mandar un mensaje");
    }

    @GetMapping("/getMessagesReceived")
    public ResponseEntity<?> receivedMessages(@RequestHeader("Authorization") String tokenHeader) {
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            String token = tokenHeader.substring(7);
            if (jwtUtils.isTokenValid(token)) {
                String username = jwtUtils.getUsernameFromToken(token);

                return ResponseEntity.ok(messageRepository.findAllByReceiver_Username(username));
            }

        }
        return ResponseEntity.badRequest().body("Requiere haber una sesion activa para obtener los mensajes del usuario");
    }
}
