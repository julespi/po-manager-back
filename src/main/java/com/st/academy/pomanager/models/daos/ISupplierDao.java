package com.st.academy.pomanager.models.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.academy.pomanager.models.entities.Supplier;

public interface ISupplierDao extends JpaRepository<Supplier, Long>{

}
