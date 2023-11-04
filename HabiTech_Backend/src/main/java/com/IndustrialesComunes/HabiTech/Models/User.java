package com.IndustrialesComunes.HabiTech.Models;

// Aca se debe definir como funciona un usuario

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// quedan comentadas las anotaciones necesarias a futuro

/*
@Entity
@Table(name = "usuarios")
@ToString @EqualsAndHashCode
 */
public class User {
/*
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
*/
    private long id;
}
