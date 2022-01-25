package com.st.academy.pomanager.models.repositories;

import com.st.academy.pomanager.models.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailDao extends JpaRepository<OrderDetail, Long>{

}
