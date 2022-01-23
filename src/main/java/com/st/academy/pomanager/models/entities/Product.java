package com.st.academy.pomanager.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private Integer stock;

    @Column(name = "unidades_reposicion")
    private Integer restock;

    @Column(name = "flg_discontinuo")
    private boolean discontinuous;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Supplier supplier;

    @Column(name = "url_imagen")
    private String imageUrl;

}
