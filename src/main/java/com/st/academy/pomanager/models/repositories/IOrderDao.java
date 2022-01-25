package com.st.academy.pomanager.models.repositories;

import com.st.academy.pomanager.models.entities.Category;
import com.st.academy.pomanager.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderDao extends JpaRepository<Order, Long>{

    List<Order> findAllByClientId(Long clientId);

    List<Order> findAllByClientIdAndIsOpen(Long clientId, boolean isOpen);

}
