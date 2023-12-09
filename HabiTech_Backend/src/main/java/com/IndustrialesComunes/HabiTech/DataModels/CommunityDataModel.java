package com.IndustrialesComunes.HabiTech.DataModels;

import com.IndustrialesComunes.HabiTech.Models.Building;
import com.IndustrialesComunes.HabiTech.Models.Community;
import com.IndustrialesComunes.HabiTech.Models.Fondos;
import com.IndustrialesComunes.HabiTech.Models.User;

import java.util.List;

public interface CommunityDataModel {
    List<Community> getCommunitys();
    Community getCommunity(long id);
    void addCommunity(Community com);

    // falta implementar
    void eliminarCommunity(Long id);

    List<Building> getBuildByID(Long id);
}
