package com.IndustrialesComunes.HabiTech.repositories;

import com.IndustrialesComunes.HabiTech.Models.RoleEntity;
import com.IndustrialesComunes.HabiTech.Models.UnidadEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends CrudRepository<UnidadEntity, Long> {
}
