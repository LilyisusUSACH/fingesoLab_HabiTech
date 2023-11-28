package com.IndustrialesComunes.HabiTech.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fondos")
public class Fondos{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private long id;

    @Getter @Setter
    @Column(name = "nombreFondo")
    private String nameFondo;

    @Getter
    @Column(name = "cantidadFondo")
    private int value;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Comunnity community;

    private void descontarFondo(){}

    private void añadirFondo(){}
}
