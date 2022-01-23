package com.st.academy.pomanager.models.services;

import com.st.academy.pomanager.models.entities.Order;
import com.st.academy.pomanager.models.entities.Supplier;
import com.st.academy.pomanager.models.repositories.IOrderDao;
import com.st.academy.pomanager.utils.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements CrudService<Order, Long> {

    @Autowired
    private IOrderDao iOrderDao;

    @Override
    public List<Order> findAll() {
        return iOrderDao.findAll();
    }

    @Override
    public Order save(Order order) {
        return iOrderDao.save(order);
    }

    @Override
    public void delete(Long id) {
        iOrderDao.deleteById(id);

    }

    @Override
    public Order findById(Long id) throws DBException {
        return iOrderDao.findById(id).orElseThrow(() -> new DBException("No order found with id: " + id));
    }

    @Override
    public Order update(Order order, Long id) {
        return null;
    }

}
