package com.IndustrialesComunes.HabiTech.Models;

import jakarta.annotation.Nullable;
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
@Table(name = "unidad")
public class UnidadEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ubication;

    private int m2 = 0;

    private float prorrateo;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private BuildingEntity edificio;

    @ManyToOne
    @JoinColumn(name = "residente_id")
    private UserEntity residente;

    @OneToMany(mappedBy = "unidad")
    private List<ExtraUnidadEntity> extra;

/*
    private void calcularProrrateo(){
        this.prorrateo = 0;
    }
*/

}
