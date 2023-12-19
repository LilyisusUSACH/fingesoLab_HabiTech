package com.IndustrialesComunes.HabiTech.repositories;

import com.IndustrialesComunes.HabiTech.Models.ComprobanteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComprobanteRepository extends CrudRepository<ComprobanteEntity,Long>{
    List<ComprobanteEntity> findAllByResidenteUsername(String username);
}
