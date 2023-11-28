package com.IndustrialesComunes.HabiTech.Models.userTypes;


import com.IndustrialesComunes.HabiTech.Models.User;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="rol")
public abstract class Admin extends User{
    public void ingresarGastoComun(){}
    public void registrarUsuarios(){}
    public void aprobarSolicitudUsuarios(){}
    public void modificarFondos(){}
    public void eliminarResidente(){}
    public void enviarAviso(){}
    public void verEstadisticasComunidad(){}
    public void agregarComunidad(){}
    public void modificarComunidad(){}
    public void agregarComite(){}
    public void modificarComite(){}
    public void agregarAnalistaComunidad(){}
    public void modificarAnalistaComunidad(){}

}
