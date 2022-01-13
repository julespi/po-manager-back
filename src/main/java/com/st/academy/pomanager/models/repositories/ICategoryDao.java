package com.st.academy.pomanager.models.repositories;

import com.st.academy.pomanager.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryDao extends JpaRepository<Category, Long>{

}
