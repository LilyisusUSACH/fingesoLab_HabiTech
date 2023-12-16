package com.IndustrialesComunes.HabiTech.repositories;

import com.IndustrialesComunes.HabiTech.Models.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByRut(Integer rut);

    @Query("select u from UserEntity u where u.username = ?1")
    Optional<UserEntity> getName(String username);
}
