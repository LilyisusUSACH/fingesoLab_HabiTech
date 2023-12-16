package com.IndustrialesComunes.HabiTech.Controllers;

import com.IndustrialesComunes.HabiTech.Models.UserEntity;
import com.IndustrialesComunes.HabiTech.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin(){
            return "Hola, has accedido con rol de ADMIN";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/accessUser")
    public String accessUser(){
        return "Hola, has accedido con rol de User";
    }

    @PreAuthorize("hasRole('INVITED')")
    @GetMapping("/accessInvited")
    public String accessInvited(){
        return "Hola, has accedido con rol de Invited";
    }

    @PreAuthorize("hasRole('SADMIN')")
    @GetMapping("/getByRut/{id}")
    public UserEntity getByRut(@PathVariable Integer id){
        return userRepository.findByRut(id).orElseThrow();
    }

}
