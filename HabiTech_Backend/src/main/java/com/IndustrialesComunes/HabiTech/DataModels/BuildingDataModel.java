package com.IndustrialesComunes.HabiTech.DataModels;

import com.IndustrialesComunes.HabiTech.Models.Building;
import com.IndustrialesComunes.HabiTech.Models.Community;

import java.util.List;

public interface BuildingDataModel {

    List<Building> getBuildings();
    Building getBuilding(long id);
    void addBuilding(Building building);

    // falta implementar
    void eliminarBuilding(Long id);

}
