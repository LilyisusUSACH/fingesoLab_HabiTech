package com.IndustrialesComunes.HabiTech.Models.userTypes;

import com.IndustrialesComunes.HabiTech.Models.Deuda;
import com.IndustrialesComunes.HabiTech.Models.User;
import com.IndustrialesComunes.HabiTech.Models.Unidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("residente")
public class Residente extends User{

    @OneToMany(mappedBy = "residente")
    private List<Unidad> unidades;

    @OneToMany(mappedBy = "residente")
    private List<Deuda> deudas;

    public int verDeuda(){
        return 0;
    }
    public String verDetalleUnidades(){
        return "";
    }
    public String verDetallesGastos(){
        return "";
    }
    public void pagarDeuda(){}

    public String verComprobante(){
        return "";
    }

    public String verEstadisticas(){
        return "";
    }
}
