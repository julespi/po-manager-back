package com.st.academy.pomanager.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto")
public class Product {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Getter
    @Setter
    @Column(name = "descripcion")
    private String description;

    @Getter
    @Setter
    @Column(name = "precio_unitario")
    private Long unitPrice;

    @Getter
    @Setter
    @Column(name = "unidades_stock")
    private int stock;

    @Getter
    @Setter
    @Column(name = "unidades_reposicion")
    private int restock;

    @Getter
    @Setter
    @Column(name = "flg_discontinuo")
    private boolean discontinuous;

    @Getter
    @Setter
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Category category;

}
