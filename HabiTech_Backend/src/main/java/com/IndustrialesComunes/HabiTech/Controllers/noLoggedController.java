package com.IndustrialesComunes.HabiTech.Controllers;


import com.IndustrialesComunes.HabiTech.Controllers.request.CreateUserDTO;
import com.IndustrialesComunes.HabiTech.Models.ERole;
import com.IndustrialesComunes.HabiTech.Models.RoleEntity;
import com.IndustrialesComunes.HabiTech.Models.UserEntity;
import com.IndustrialesComunes.HabiTech.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class noLoggedController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> createResidente(@Valid @RequestBody CreateUserDTO createUserDTO){
        UserEntity userEntity = UserEntity.builder()
                .rut(createUserDTO.getRut())
                .username(String.valueOf(createUserDTO.getRut()))
                .name(createUserDTO.getName())
                .lastName(createUserDTO.getLastName())
                //.password(createUserDTO.getPassword())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .email(createUserDTO.getEmail())
                .roles(
                        Set.of(
                                RoleEntity.builder()
                                        .name(ERole.valueOf(ERole.RESIDENTE.name()))
                                        .build()
                        )
                )
                .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }

}
