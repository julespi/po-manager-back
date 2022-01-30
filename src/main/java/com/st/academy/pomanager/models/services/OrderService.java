package com.st.academy.pomanager.models.services;

import com.st.academy.pomanager.models.entities.*;
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

    @Autowired
    private ProductService productService;

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
        order.setActive(true);
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
        Order oldOrder = this.findById(id);
        order.setId(id);
        return iOrderDao.save(order);
    }

    public Order confirm(Order order, Long id) throws DBValidationException{
        Order oldOrder = this.findById(id);
        order.setId(id);
        for(OrderDetail detail:order.getDetails()){
            Product product = productService.findById(detail.getProduct().getId());
            if(product.getStock() - detail.getQuantity() < 0){
                throw new DBValidationException("No hay stock suficiente para el producto: " + product.getDescription());
            }
        }
        for(OrderDetail detail:order.getDetails()){
            Product product = productService.findById(detail.getProduct().getId());
            product.setStock(product.getStock() - detail.getQuantity());
        }
        order.setIsOpen(false);
        return iOrderDao.save(order);
    }

    public List<Order> findAllByClientId(Long clientId) {
        return iOrderDao.findAllByClientId(clientId);
    }

    public List<Order> findAllByClientIdAndIsOpen(Long clientId, boolean isOpen) {
        return iOrderDao.findAllByClientIdAndIsOpen(clientId, isOpen);
    }

    public Order saveDetailForUser(OrderDetail detail, Long userId) {
        List<Order> orders = this.findAllByClientIdAndIsOpen(userId,true);
        Order resultOrder;
        if(!orders.isEmpty()){
            resultOrder = orders.get(0);
            detail.setOrder(resultOrder);
            detail.setActive(true);
            resultOrder.addDetail(detail);
            iOrderDetailDao.save(detail);
        }else{
            Order newOrder = new Order();
            newOrder.addDetail(detail);
            User user = new User();
            user.setId(userId);
            newOrder.setClient(user);
            newOrder.setIsOpen(true);
            resultOrder = iOrderDao.save(newOrder);
            detail.setOrder(resultOrder);
            iOrderDetailDao.save(detail);
        }
        return resultOrder;
    }
}
