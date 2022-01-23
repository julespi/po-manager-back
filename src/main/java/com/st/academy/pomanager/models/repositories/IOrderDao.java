package com.st.academy.pomanager.models.repositories;

import com.st.academy.pomanager.models.entities.Category;
import com.st.academy.pomanager.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDao extends JpaRepository<Order, Long>{

}
