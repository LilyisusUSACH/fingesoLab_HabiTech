package com.IndustrialesComunes.HabiTech.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    private String name;

    private String ubication;

    private int m2 = 0;

    private float prorrateo = 0;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    @JsonIgnore
    private BuildingEntity edificio;

    @ManyToOne
    @JoinColumn(name = "residente_id")
    @JsonIgnore
    private UserEntity residente;

    @OneToMany(mappedBy = "unidad")
    private List<ExtraUnidadEntity> extra = new ArrayList<>();

/*
    private void calcularProrrateo(){
        this.prorrateo = 0;
    }
*/
    @JsonGetter("residente")
    private ObjectNode getResidenteInfo(){
        ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("id", residente.getId());
        node.put("rut",residente.getRut());
        node.put("email",residente.getEmail());
        return node;
    }

    @JsonGetter("edificio")
    private ObjectNode getBuildingInfo(){
        ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("id", edificio.getId());
        node.put("m2",edificio.getM2());
        node.put("community_id",edificio.getCommunity().getId());
        return node;
    }

    public int getTotalM2(){
        int m2 = 0;
        if(extra != null){
            for(ExtraUnidadEntity xtra : extra){
                m2 += xtra.getM2e();
            }
        }
        return getM2() + m2;
    }

}
