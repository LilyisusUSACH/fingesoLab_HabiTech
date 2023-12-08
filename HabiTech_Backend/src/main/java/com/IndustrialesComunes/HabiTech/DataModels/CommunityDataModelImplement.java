package com.IndustrialesComunes.HabiTech.DataModels;

import com.IndustrialesComunes.HabiTech.Models.Community;
import com.IndustrialesComunes.HabiTech.Models.Fondos;
import com.IndustrialesComunes.HabiTech.Models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CommunityDataModelImplement implements CommunityDataModel {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Community> getCommunitys() {
        String query = "FROM Community";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Community getCommunity(long id) {
        String query = "FROM Community where id = :id";
        return (Community) entityManager.createQuery(query).setParameter("id",id).getSingleResult();
    }

    @Override
    public void addCommunity(Community com) {
        // Fondos por defecto (?
        Fondos fondoReserva = new Fondos("Fondo reserva",0, com);
        Fondos fondoDanos = new Fondos("Fondo daños",0, com);
        com.fondos.add(fondoReserva);
        com.fondos.add(fondoDanos);
        entityManager.merge(com);
    }

    @Override
    public void eliminarCommunity(Long id) {

    }
}
