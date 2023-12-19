package com.IndustrialesComunes.HabiTech.repositories;

import com.IndustrialesComunes.HabiTech.Models.DeudaEntity;
import com.IndustrialesComunes.HabiTech.Models.RoleEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeudaRepository extends CrudRepository<DeudaEntity, Long> {
    List<DeudaEntity> findAllByResidenteUsername(String username);
}
