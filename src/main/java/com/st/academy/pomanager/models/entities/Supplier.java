package com.st.academy.pomanager.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="suppliers")
public class Supplier {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Getter
    @Setter
    @Column(nullable = false)
    private String name;
    
    @Getter
    @Setter
    private String address;
    
    @Getter
    @Setter
    @Column(nullable = false)
    private Integer cuit;
}
