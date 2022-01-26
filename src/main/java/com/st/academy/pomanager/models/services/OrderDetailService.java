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
public class OrderDetailService implements CrudService<OrderDetail, Long> {

    @Autowired
    private IOrderDetailDao iOrderDetailDao;

    @Override
    public List<OrderDetail> findAll() {
        return iOrderDetailDao.findAll();
    }

    @Override
    public OrderDetail save(OrderDetail detail) throws DBNotFoundException {return null;
    }

    @Override
    public void delete(Long id) {
        iOrderDetailDao.findById(id).orElseThrow(() -> new DBNotFoundException("No order found with id: " + id));
        iOrderDetailDao.deleteById(id);
    }

    @Override
    public OrderDetail findById(Long id) throws DBNotFoundException {
        return iOrderDetailDao.findById(id).orElseThrow(() -> new DBNotFoundException("No order found with id: " + id));
    }

    @Override
    public OrderDetail update(OrderDetail detail, Long id) {
        return null;
    }
}
