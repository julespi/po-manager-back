package com.st.academy.pomanager.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.academy.pomanager.models.daos.ISupplierDao;
import com.st.academy.pomanager.models.entities.Supplier;

@Service
public class SupplierService implements CrudService<Supplier>{
    
    @Autowired
    private ISupplierDao iSupplierDao;

    @Override
    public List<Supplier> findAll(){
	return iSupplierDao.findAll();
    }

    @Override
    public Supplier save(Supplier supplier) {
	return iSupplierDao.save(supplier);
    }

    @Override
    public void delete(Long id) {
	iSupplierDao.deleteById(id);
	
    }

    @Override
    public Supplier findById(Long id) {
	return iSupplierDao.findById(id).orElse(null);
    }
    
    

}
