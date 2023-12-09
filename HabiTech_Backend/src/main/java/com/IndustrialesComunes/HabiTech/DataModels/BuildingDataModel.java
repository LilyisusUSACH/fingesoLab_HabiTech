package com.IndustrialesComunes.HabiTech.DataModels;

import com.IndustrialesComunes.HabiTech.Models.Building;
import com.IndustrialesComunes.HabiTech.Models.Community;

import java.util.List;

public interface BuildingDataModel {

    List<Building> getBuildings();
    Building getBuilding(long id);

    Building addBuilding(Building build);

    Building addBuilding(String Ubication, int nOfUnits, int commId);

    // falta implementar
    void eliminarBuilding(Long id);

}
