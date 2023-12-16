package com.IndustrialesComunes.HabiTech.Models;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Size(max = 80)
    private String email;

    @NonNull
    @Min(0)
    @Max(999999999)
    private Integer rut;

    @NotBlank
    @Size(max = 9)
    private String username;

    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

    // Solo asignar a residentes

    @OneToMany(mappedBy = "residente")
    private List<UnidadEntity> unidades = new ArrayList<>();

    @OneToMany(mappedBy = "residente")
    private List<DeudaEntity> deudas  = new ArrayList<>();

    @OneToMany(mappedBy = "sender",targetEntity = MessageEntity.class)
    private List<MessageEntity> messagesSended  = new ArrayList<>();

    @OneToMany(mappedBy = "receiver",targetEntity = MessageEntity.class)
    private List<MessageEntity> messagesReceived  = new ArrayList<>();


}
