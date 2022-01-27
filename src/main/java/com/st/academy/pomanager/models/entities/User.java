package com.st.academy.pomanager.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(optional=true, fetch=FetchType.LAZY)
    @JoinColumn(name="administrador")
    private User manager;

    @JsonIgnore
    @OneToMany(mappedBy = "manager",fetch = FetchType.LAZY)
    private Set<User> employees = new HashSet<>();
}
