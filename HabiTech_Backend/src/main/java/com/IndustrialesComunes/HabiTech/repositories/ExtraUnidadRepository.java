package com.IndustrialesComunes.HabiTech.repositories;

import com.IndustrialesComunes.HabiTech.Models.ExtraUnidadEntity;
import com.IndustrialesComunes.HabiTech.Models.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraUnidadRepository extends CrudRepository<ExtraUnidadEntity, Long> {
}
