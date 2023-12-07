package com.IndustrialesComunes.HabiTech.Models;

// Aca se debe definir como funciona un usuario

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="rol")

@EqualsAndHashCode @ToString
public abstract class User{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="password_id")
    public Password password;


    private void registrarse(){}

    public void iniciarSesion(User usuario){}

    public void cerrarSesion(){}

    public void updateInformation(){}

    public void reestablecerPass(){}

    public void verAvisos(){}

    public void verMensajes(){}

    public void enviarMensaje(){}

}
