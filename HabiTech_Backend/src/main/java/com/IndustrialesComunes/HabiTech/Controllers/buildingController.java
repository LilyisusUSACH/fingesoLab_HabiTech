package com.IndustrialesComunes.HabiTech.Controllers;

import com.IndustrialesComunes.HabiTech.DataModels.BuildingDataModel;
import com.IndustrialesComunes.HabiTech.DataModels.UserDataModel;
import com.IndustrialesComunes.HabiTech.Models.Building;
import com.IndustrialesComunes.HabiTech.Models.Community;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class buildingController {
    @Autowired
    private BuildingDataModel buildDM;

    @RequestMapping(value = "api/buildings", method = RequestMethod.GET)
    @Transactional
    public List<Building> getBuildings() {
        return buildDM.getBuildings();
    }

    @RequestMapping(value = "api/buildings/{id}", method = RequestMethod.GET)
    @Transactional
    public ResponseEntity<Building> getBuilding(@PathVariable Long id) {
        try{
            return ResponseEntity.ok().body(buildDM.getBuilding(id));
        } catch (Exception e){ // if e == no encontrado
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "api/buildingsByComID", method = RequestMethod.POST)
    @Transactional
    public Building registrarBuilding(@RequestBody ObjectNode body){
        return buildDM.addBuilding(body.get("ubication").asText(), body.get("nOfUnits").asInt(),body.get("community_id").asInt());
    }

    @RequestMapping(value = "api/buildings", method = RequestMethod.POST)
    @Transactional
    public Building registrarBuilding(@RequestBody Building build){
        return buildDM.addBuilding(build);
    }

}
