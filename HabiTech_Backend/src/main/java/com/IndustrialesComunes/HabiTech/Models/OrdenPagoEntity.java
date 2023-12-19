package com.IndustrialesComunes.HabiTech.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ordenPago")
public class OrdenPagoEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empresa = "Habitech";

    private double value;

    private String medioPago = "";

    @OneToMany(mappedBy = "ordenPago")
    @JsonIgnore
    private List<DeudaEntity> deudasAsociadas = new ArrayList<>();

    @OneToOne(mappedBy = "ordenPago")
    @JsonIgnore
    private ComprobanteEntity comprobante;

    @JsonGetter("comprobante_id")
    private Long comprobanteID(){
        if(comprobante!=null){
            return comprobante.getId();
        }else{
            return null;
        }
    }
}
