package com.st.academy.pomanager.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orden")
public class Order extends BasePersistanceEntity {

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private User client;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = true)
    private User employee;

    @Column(name = "fecha_entregada")
    private Date delivered;

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private Set<OrderDetail> details = new HashSet<>();

    @Column(name = "esta_abierta")
    private Boolean isOpen;

    @Transient
    private Integer detailsQty;


    @PostLoad
    private void onLoad() {
        this.detailsQty = details.size();
    }
}
