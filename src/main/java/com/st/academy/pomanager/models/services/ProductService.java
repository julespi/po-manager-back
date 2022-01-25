package com.st.academy.pomanager.models.services;

import java.util.List;

import com.st.academy.pomanager.utils.DBNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.st.academy.pomanager.models.repositories.IProductDao;
import com.st.academy.pomanager.models.entities.Product;

@Service
public class ProductService implements CrudService<Product, Long> {

    @Autowired
    private IProductDao iProductDao;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<Product> findAll() {
        return iProductDao.findAll();
    }

    public Page<Product> findAllPageable(Pageable pageable) {
        return iProductDao.findAll(pageable);
    }

    @Override
    public Product save(Product product) {
        //TODO esta bien esto como validacion?
        supplierService.findById(product.getSupplier().getId());
        categoryService.findById(product.getCategory().getId());
        return iProductDao.save(product);
    }

    @Override
    public void delete(Long id) {
        iProductDao.deleteById(id);

    }

    @Override
    public Product findById(Long id) throws DBNotFoundException {
        //TODO es esto lo mejor que se puede hacer?
        // en el controller hacer el control del null m parece demasiado, y del lado del dao tmb
        return iProductDao.findById(id).orElseThrow(() -> new DBNotFoundException("No record found with id: " + id));
    }

    @Override
    public Product update(Product product, Long id) {
        Product oldProduct = iProductDao.findById(id).orElseThrow(() -> new DBNotFoundException("No record found with id: " + id));
        product.setId(id);
        product.setCreated(oldProduct.getCreated());
        return iProductDao.save(product);
    }

    public Page<Product> findByDescriptionContaining(String description, Pageable pageable) {
        return iProductDao.findByDescriptionContaining(description,pageable);
    }
}
