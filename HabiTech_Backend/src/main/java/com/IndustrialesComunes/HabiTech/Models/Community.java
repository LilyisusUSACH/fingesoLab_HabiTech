package com.IndustrialesComunes.HabiTech.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comunidad")
@ToString
public class Community {

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


    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    public List<Fondos> fondos;
    // cuando añada una comunidad se añadira con 3 fondos

    @OneToMany(mappedBy = "community")
    private List<Building> edificios;


    public Community(){
        this.fondos = new ArrayList<>();
        this.edificios = new ArrayList<>();
    }
}
