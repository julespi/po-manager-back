package com.st.academy.pomanager.models.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.academy.pomanager.models.entities.Product;

public interface IProductDao extends JpaRepository<Product, Long>{

}
