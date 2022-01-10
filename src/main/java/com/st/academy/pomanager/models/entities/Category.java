package com.st.academy.pomanager.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categoria")
public class Category extends BasePersistanceEntity{

    @Getter
    @Setter
    @Column(name = "descripcion")
    private String description;

    @Getter
    @Setter
    @JsonBackReference
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "proveedor_categoria", joinColumns = {
	    @JoinColumn(name = "id_categoria") }, inverseJoinColumns = { @JoinColumn(name = "id_proveedor") })
    private Set<Supplier> suppliers = new HashSet<>();

    @Getter
    @Setter
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();;
}
