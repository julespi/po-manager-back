package com.st.academy.pomanager.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="usuario")
public class User extends BasePersistanceEntity{
    

    @Column(name = "correo_electronico")
    private String email;

    @Column(name = "contrasenia")
    private String password;

    @Column(name = "nombre")
    private String first_name;

    @Column(name = "apellido")
    private String last_name;

    @Column(name = "direccion",nullable = true)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private UserRole role;

    @ManyToOne(optional=true, fetch=FetchType.LAZY)
    @JoinColumn(name="administrador")
    private User manager;

    @OneToMany(mappedBy = "manager")
    private Set<User> employees = new HashSet<>();;
}
