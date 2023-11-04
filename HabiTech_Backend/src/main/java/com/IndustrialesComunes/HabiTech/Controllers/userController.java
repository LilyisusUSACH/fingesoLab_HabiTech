package com.IndustrialesComunes.HabiTech.Controllers;

import com.IndustrialesComunes.HabiTech.DataModels.UserDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {
    @Autowired
    private UserDataModel userDM;

    @RequestMapping(value = "api/", method = RequestMethod.GET)
    public String getApi(){
        return "aaaaaaaa";
    }
    // en la funcion pedir @RequestHeader(value="Authorization") String token - para confirmar sesion iniciada

}
