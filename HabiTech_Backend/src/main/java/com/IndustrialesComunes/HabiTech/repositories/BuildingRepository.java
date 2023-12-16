package com.IndustrialesComunes.HabiTech.repositories;

import com.IndustrialesComunes.HabiTech.Models.BuildingEntity;
import com.IndustrialesComunes.HabiTech.Models.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BuildingRepository extends CrudRepository<BuildingEntity, Long> {

}
