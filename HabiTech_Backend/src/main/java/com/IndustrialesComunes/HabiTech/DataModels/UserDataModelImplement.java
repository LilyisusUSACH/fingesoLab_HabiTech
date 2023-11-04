package com.IndustrialesComunes.HabiTech.DataModels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

// Aca se debe implementar la interface anterior
@Repository
@Transactional
public class UserDataModelImplement implements UserDataModel {
    @PersistenceContext
    EntityManager entityManager;
}
