package com.IndustrialesComunes.HabiTech.Controllers;

import com.IndustrialesComunes.HabiTech.Controllers.request.CreateUserDTO;
import com.IndustrialesComunes.HabiTech.Models.ERole;
import com.IndustrialesComunes.HabiTech.Models.RoleEntity;
import com.IndustrialesComunes.HabiTech.Models.UserEntity;
import com.IndustrialesComunes.HabiTech.repositories.RoleRepository;
import com.IndustrialesComunes.HabiTech.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sadmin")
public class sadminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("reg/gadmin")
    @PreAuthorize("hasRole('SADMIN')")
    public ResponseEntity<?> createGeneralAdmin(@Valid @RequestBody CreateUserDTO createUserDTO){
        UserEntity userEntity = UserEntity.builder()
                .rut(createUserDTO.getRut())
                .username(String.valueOf(createUserDTO.getRut()))
                .name(createUserDTO.getName())
                .lastName(createUserDTO.getLastName())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .email(createUserDTO.getEmail())
                .roles(
                        Set.of(
                                roleRepository.findByName(ERole.valueOf(ERole.RESIDENTE.name())).orElse(
                                        RoleEntity.builder()
                                        .name(ERole.valueOf(ERole.GADMIN.name()))
                                        .build()
                                )
                        )
                )
                .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }

}
