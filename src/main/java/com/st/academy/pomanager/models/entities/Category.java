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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Table(name = "categoria")
@SQLDelete(sql = "UPDATE categoria SET activo = false WHERE id=?")
@Where(clause = "activo=true")
public class Category extends BasePersistanceEntity{

    @Column(name = "descripcion")
    private String description;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "proveedor_categoria", joinColumns = {
            @JoinColumn(name = "id_categoria") }, inverseJoinColumns = { @JoinColumn(name = "id_proveedor") })
    @JsonIgnore
    private Set<Supplier> suppliers = new HashSet<>();

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();;
}
