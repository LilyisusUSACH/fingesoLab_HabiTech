package com.IndustrialesComunes.HabiTech.Controllers;

import com.IndustrialesComunes.HabiTech.DataModels.UserDataModel;
import com.IndustrialesComunes.HabiTech.Models.User;
import com.IndustrialesComunes.HabiTech.Models.userTypes.Residente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
public class userController {
    @Autowired
    private UserDataModel userDM;

    @RequestMapping(value = "api/", method = RequestMethod.GET)
    public String getApi(){
        return " ";
    }


    // Cambiar todo lo posible a responseEntity despues
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    @Transactional
    public ResponseEntity<User> getUsuario(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(userDM.getUsuario(id));
        } catch (Exception e){ // if e == no encontrado
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    @Transactional
    public List<User> getUsuarios() {
        return userDM.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    @Transactional
    public String registrarUsuario(@RequestBody Residente usuario) {
        userDM.registrar(usuario);
        return usuario.toString();
    }
    // en la funcion pedir @RequestHeader(value="Authorization") String token - para confirmar sesion iniciada

}
