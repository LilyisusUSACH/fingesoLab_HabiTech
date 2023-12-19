package com.IndustrialesComunes.HabiTech.repositories;

import com.IndustrialesComunes.HabiTech.Models.ComprobanteEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ComprobanteRepository extends CrudRepository<ComprobanteEntity,Long>{
    List<ComprobanteEntity> findAllByResidenteUsername(String username);

    List<ComprobanteEntity> findTop2ByResidenteUsername(String username);
}
