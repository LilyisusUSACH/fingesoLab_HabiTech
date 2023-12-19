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

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comprobante")
public class ComprobanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valor;

    private LocalDate fechaPago;

    @ManyToOne
    @JoinColumn(name = "residente_id")
    @JsonIgnore
    private UserEntity residente;

    @OneToOne
    @JoinColumn(name = "ordenPago_id")
    private OrdenPagoEntity ordenPago;

    @JsonGetter("residente")
    private ObjectNode getResidenteInfo(){
        ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("id", residente.getId());
        node.put("rut",residente.getRut());
        node.put("email",residente.getEmail());
        return node;
    }

}
