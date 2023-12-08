package com.IndustrialesComunes.HabiTech.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Community community;

    public Fondos(){
        this.value = 0;
    }
    public Fondos(String nameFondo, int value, Community community) {
        this.nameFondo = nameFondo;
        this.value = value;
        this.community = community;
    }

    private void descontarFondo(){}

    private void añadirFondo(){}

    @Override
    public String toString() {
        return "Fondos{" +
                "nameFondo='" + nameFondo + '\'' +
                ", value=" + value +
                '}';
    }
}
