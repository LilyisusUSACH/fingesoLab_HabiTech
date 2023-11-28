package com.IndustrialesComunes.HabiTech.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "comunidad")
public class Comunnity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private long id;

    @Getter @Setter
    @Column(name = "ubicacion")
    private String ubication;

    @Getter @Setter
    @Column(name = "cantidadEdificios")
    private int nOfBuilds;

    @OneToMany(mappedBy = "community")
    private List<Fondos> fondos;

    @OneToMany(mappedBy = "community")
    private List<Building> edificios;

}
