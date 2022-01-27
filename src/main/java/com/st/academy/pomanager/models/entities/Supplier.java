package com.st.academy.pomanager.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Table(name="proveedor")
@SQLDelete(sql = "UPDATE proveedor SET activo = false WHERE id=?")
@Where(clause = "activo=true")
public class Supplier extends BasePersistanceEntity{
    

    @Column(name = "empresa")
    private String company;

    @Column(name = "contacto")
    private String contact;

    @Column(name = "direccion")
    private String address;

    @ManyToMany(mappedBy = "suppliers")
    @JsonIgnore
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();
}
