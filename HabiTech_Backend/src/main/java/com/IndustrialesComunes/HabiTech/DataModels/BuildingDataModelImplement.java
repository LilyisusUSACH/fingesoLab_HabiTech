package com.IndustrialesComunes.HabiTech.DataModels;

import com.IndustrialesComunes.HabiTech.DataModels.CommunityDataModelImplement;
import com.IndustrialesComunes.HabiTech.Models.Building;
import com.IndustrialesComunes.HabiTech.Models.Community;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Transactional
public class BuildingDataModelImplement implements BuildingDataModel{
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private CommunityDataModel comDM;

    @Override
    @Transactional
    public List<Building> getBuildings() {
        String query = "FROM Building";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public Building getBuilding(long id) {
        String query = "FROM Building Where id = :id";
        return (Building) entityManager.createQuery(query).setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public Building addBuilding(Building build) {
        return entityManager.merge(build);
    }

    @Override
    @Transactional
    public Building addBuilding(String Ubication, int nOfUnits, int commId) {
        Community community = comDM.getCommunity(commId);
        Building building = new Building(Ubication, nOfUnits, community);
        entityManager.merge(building);
        entityManager.merge(community);
        return getBuilding(building.getId());
    }

    @Override
    public void eliminarBuilding(Long id) {

    }
}
