package com.st.academy.pomanager.models.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="categoria")
public class Category {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;
    
    @Getter
    @Setter
    @Column(name = "descripcion")
    private String description;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "proveedor_categoria", 
        joinColumns = { @JoinColumn(name = "id_categoria") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_proveedor") }
    )
    List<Supplier> suppliers = new ArrayList<>();
}
