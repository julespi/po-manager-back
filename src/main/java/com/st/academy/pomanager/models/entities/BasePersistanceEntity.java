package com.st.academy.pomanager.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class BasePersistanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "creado") //, nullable = false, updatable = false)
    //TODO al poner updateable en false, y hacer un save, el objeto resultante no posee created pero si en la DB
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

    @Column(name = "actualizado")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updated;

    @Column(name = "activo",nullable = false)
    @ColumnDefault("true")
    private boolean active = true;

    /*@PrePersist
    protected void onCreate() {
        this.created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated = new Date();
    }*/
}

