package com.IndustrialesComunes.HabiTech.Models;

import com.fasterxml.jackson.annotation.*;
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
    public List<Fondos> fondos = new ArrayList<>();
    // cuando añada una comunidad se añadira con 3 fondos

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    @JsonIgnore @Getter
    //@JsonManagedReference
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Building> edificios = new ArrayList<>();

    public void addEdificio(Building build){
        edificios.add(build);
    }

    @JsonGetter("edificios")
    public String edificios(){
        String str = "[";
        for(Building build: edificios){
            str += build.getId() + " ";
        }
        str += "]";
        return str;
    }

}
