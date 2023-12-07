package com.IndustrialesComunes.HabiTech.DataModels;

import com.IndustrialesComunes.HabiTech.Models.Password;
import com.IndustrialesComunes.HabiTech.Models.User;
import com.IndustrialesComunes.HabiTech.Models.userTypes.Residente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

// Aca se debe implementar la interface anterior
@Repository
@Transactional
public class UserDataModelImplement implements UserDataModel {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getUsuarios() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public void registrar(User user) {
        entityManager.merge(user);
    }

}
