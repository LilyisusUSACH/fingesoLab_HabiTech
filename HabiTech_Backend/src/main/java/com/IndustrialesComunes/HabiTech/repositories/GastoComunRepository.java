package com.IndustrialesComunes.HabiTech.repositories;

import com.IndustrialesComunes.HabiTech.Models.GastoComunEntity;
import com.IndustrialesComunes.HabiTech.Models.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoComunRepository extends CrudRepository<GastoComunEntity, Long> {
}
