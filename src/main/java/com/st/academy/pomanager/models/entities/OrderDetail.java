package com.st.academy.pomanager.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "detalle_orden")
public class OrderDetail extends BasePersistanceEntity {

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Product product;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "precio_venta")
    private Integer sale_price;

}
