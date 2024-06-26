package com.IndustrialesComunes.HabiTech.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "unidadExtra")
public class ExtraUnidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EEUnitType type;

    private int m2e;

    @ManyToOne
    @JoinColumn(name = "unidad_id")
    @JsonIgnore
    private UnidadEntity unidad;

    @JsonGetter("unidad_id")
    private ObjectNode getUnidadInfo(){
        ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("id", unidad.getId());
        node.put("name", unidad.getName());
        node.put("ubication", unidad.getUbication());
        node.put("unidad_m2", unidad.getM2());
        node.put("unidad_Total_m2", unidad.getTotalM2());
        return node;
    }
}
