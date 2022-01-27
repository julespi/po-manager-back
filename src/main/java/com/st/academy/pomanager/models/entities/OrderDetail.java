package com.st.academy.pomanager.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "detalle_orden")
@SQLDelete(sql = "UPDATE detalle_orden SET activo = false WHERE id=?")
@Where(clause = "activo=true")
public class OrderDetail extends BasePersistanceEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private Product product;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "precio_venta")
    private Integer unitSalePrice;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_orden")
    private Order order;

}
