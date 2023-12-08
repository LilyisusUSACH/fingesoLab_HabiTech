package com.IndustrialesComunes.HabiTech.DataModels;

import com.IndustrialesComunes.HabiTech.Models.Building;
import com.IndustrialesComunes.HabiTech.Models.Community;
import com.IndustrialesComunes.HabiTech.Models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BuildingDataModelImplement implements BuildingDataModel{
    @PersistenceContext
    EntityManager entityManager;

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
    public void addBuilding(Building building) {
        entityManager.merge(building);
    }

    @Override
    public void eliminarBuilding(Long id) {

    }
}
