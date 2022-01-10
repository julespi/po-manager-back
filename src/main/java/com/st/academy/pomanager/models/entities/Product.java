package com.st.academy.pomanager.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Product extends BasePersistanceEntity {

    @Column(name = "descripcion")
    private String description;

    @Column(name = "precio_unitario")
    private Long unitPrice;

    @Column(name = "unidades_stock")
    private int stock;

    @Column(name = "unidades_reposicion")
    private int restock;

    @Column(name = "flg_discontinuo")
    private boolean discontinuous;

    @JsonIgnoreProperties({"id", "products"})
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Category category;

    @JsonIgnoreProperties({"products", "categories"})
    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Supplier supplier;

}
