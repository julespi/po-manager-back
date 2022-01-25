package com.st.academy.pomanager.models.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.st.academy.pomanager.models.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductDao extends JpaRepository<Product, Long>{

    /*@Query("SELECT p FROM Product p WHERE p.descripcion LIKE %:description%")
    List<Product> findByDescription(@Param("description") String description);*/

    Page<Product> findByDescriptionContaining(String description, Pageable pageable);

}
