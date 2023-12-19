package com.IndustrialesComunes.HabiTech.Models;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comunidad")
public class CommunityEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String ubication;

    private int nOfBuilds;

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    public List<FondosEntity> fondos = new ArrayList<>();

    @OneToMany(mappedBy = "community", cascade = CascadeType.ALL)
    @JsonIgnore
    @Getter

    private List<BuildingEntity> edificios = new ArrayList<>();

    @JsonGetter("edificios")
    public String edificios(){
        if(this.edificios == null){
            return "";
        }
        String str = "[";
        for(BuildingEntity build: edificios){
            str += build.getId() + " ";
        }
        str += "]";
        return str;
    }
}
