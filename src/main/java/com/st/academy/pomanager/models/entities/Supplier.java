package com.st.academy.pomanager.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="proveedor")
public class Supplier extends BasePersistanceEntity{
    
    @Getter
    @Setter
    @Column(name = "empresa")
    private String company;
    
    @Getter
    @Setter
    @Column(name = "contacto")
    private String contact;
    
    @Getter
    @Setter
    @Column(name = "direccion")
    private String address;
    
    @Getter
    @Setter
    @JsonIgnoreProperties({ "id", "suppliers" })
    @ManyToMany(mappedBy = "suppliers")
    private Set<Category> categories = new HashSet<>();
    
    @Getter
    @Setter
    @JsonIgnoreProperties({ "supplier" })
    @OneToMany(mappedBy = "supplier")
    private Set<Product> products = new HashSet<>();;
}
