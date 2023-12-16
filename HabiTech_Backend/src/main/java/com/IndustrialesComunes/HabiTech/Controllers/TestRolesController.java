package com.IndustrialesComunes.HabiTech.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {

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

}
