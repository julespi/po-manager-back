package com.st.academy.pomanager.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="proveedor")
public class Supplier {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id;
    
    @Getter
    @Setter
    @Column(name = "empresa")
    private String company;
    
    @Getter
    @Setter
    @Column(name = "contacto")
    private String contact;
    
    @Getter
    @Setter
    @Column(name = "direccion")
    private String address;
    
    @Getter
    @Setter
    @JsonManagedReference
    @ManyToMany(mappedBy = "suppliers")
    private Set<Category> categories = new HashSet<>();
    
    /*@Getter
    @Setter
    @Column(nullable = false)
    private Integer cuit;*/
}
