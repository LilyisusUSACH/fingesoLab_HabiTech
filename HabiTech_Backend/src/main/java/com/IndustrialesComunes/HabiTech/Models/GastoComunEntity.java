package com.IndustrialesComunes.HabiTech.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "gastoComun")
public class GastoComunEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String detail;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private BuildingEntity edificio;


    @ManyToMany(fetch = FetchType.EAGER, targetEntity = DeudaEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "gasto_deuda",
            joinColumns = @JoinColumn(name = "gastoComun_id"),
            inverseJoinColumns = @JoinColumn(name = "deuda_id")
    )
    public List<DeudaEntity> deudasGeneradas;

    //     private void generarDeudas(){};
}
