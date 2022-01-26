package com.st.academy.pomanager.models.services;

import com.st.academy.pomanager.models.entities.Order;
import com.st.academy.pomanager.models.entities.OrderDetail;
import com.st.academy.pomanager.models.repositories.IOrderDao;
import com.st.academy.pomanager.models.repositories.IOrderDetailDao;
import com.st.academy.pomanager.utils.DBNotFoundException;
import com.st.academy.pomanager.utils.DBValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements CrudService<Order, Long> {

    @Autowired
    private IOrderDao iOrderDao;

    @Autowired
    private IOrderDetailDao iOrderDetailDao;

    @Override
    public List<Order> findAll() {
        return iOrderDao.findAll();
    }

    @Override
    public Order save(Order order) throws DBNotFoundException {
        if(!this.findAllByClientIdAndIsOpen(order.getClient().getId(),true).isEmpty()){
            throw new DBValidationException("Ya existe una OC abierta");
        }
        for (OrderDetail detail: order.getDetails()) { //para el back reference
            detail.setOrder(order);
        }
        return iOrderDao.save(order);
    }

    @Override
    public void delete(Long id) {
        iOrderDao.findById(id).orElseThrow(() -> new DBNotFoundException("No order found with id: " + id));
        iOrderDao.deleteById(id);

    }

    @Override
    public Order findById(Long id) throws DBNotFoundException {
        return iOrderDao.findById(id).orElseThrow(() -> new DBNotFoundException("No order found with id: " + id));
    }

    @Override
    public Order update(Order order, Long id) {
        return null;
    }

    public List<Order> findAllByClientId(Long clientId) {
        return iOrderDao.findAllByClientId(clientId);
    }

    public List<Order> findAllByClientIdAndIsOpen(Long clientId, boolean isOpen) {
        return iOrderDao.findAllByClientIdAndIsOpen(clientId, isOpen);
    }
}
