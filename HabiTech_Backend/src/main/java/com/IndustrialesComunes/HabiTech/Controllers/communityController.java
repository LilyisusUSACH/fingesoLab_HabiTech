package com.IndustrialesComunes.HabiTech.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class communityController {
  /*  @Autowired
    private CommunityDataModel comDM;

    @RequestMapping(value = "api/comunidades", method = RequestMethod.GET)
    @Transactional
    public List<Community> getCommunitys() {
        return comDM.getCommunitys();
    }

    @RequestMapping(value = "api/comunidades/{id}", method = RequestMethod.GET)
    @Transactional
    public ResponseEntity<Community> getCommunity(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(comDM.getCommunity(id));
        } catch (Exception e) { // if e == no encontrado
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "api/comunidades", method = RequestMethod.POST)
    @Transactional
    public String registrarComunidad(@RequestBody Community com) {
        comDM.addCommunity(com);
        return com.toString();
    }

    @RequestMapping(value = "api/comunidades/{id}/builds", method = RequestMethod.GET)
    @Transactional
    public List<Building> getBuildsByCom(@PathVariable Long id) {
        return comDM.getBuildByID(id);
    }
*/}