package com.st.academy.pomanager.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="usuario")
@SQLDelete(sql = "UPDATE usuario SET activo = false WHERE id=?")
@Where(clause = "activo=true")
public class User extends BasePersistanceEntity{
    

    @Column(name = "correo_electronico")
    private String email;

    @Column(name = "contrasenia")
    private String password;

    @Column(name = "nombre")
    private String firstName;

    @Column(name = "apellido")
    private String lastName;

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
