package com.st.academy.pomanager.models.services;

import java.util.List;

import com.st.academy.pomanager.utils.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.academy.pomanager.models.repositories.IProductDao;
import com.st.academy.pomanager.models.entities.Product;

@Service
public class ProductService implements CrudService<Product> {

    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() {
        return iProductDao.findAll();
    }

    @Override
    public Product save(Product product) {
        return iProductDao.save(product);
    }

    @Override
    public void delete(Long id) {
        iProductDao.deleteById(id);

    }

    @Override
    public Product findById(Long id) {
        //TODO es esto lo mejor que se puede hacer?
        // en el controller hacer el control del null m parece demasiado, y del lado del dao tmb
        return iProductDao.findById(id).orElseThrow(() -> new DBException("No record found with id: " + id));
    }

}
