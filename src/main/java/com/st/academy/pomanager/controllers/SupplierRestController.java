package com.st.academy.pomanager.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.st.academy.pomanager.models.entities.Supplier;
import com.st.academy.pomanager.models.services.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierRestController implements CrudRestController<Supplier> {

    @Autowired
    private SupplierService supplierService;

    @Override
    public ResponseEntity<Map<String, Object>> create(Supplier t) {
        System.out.println("/api/suppliers/create");
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        response.put("payload", supplierService.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> findById(Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        response.put("payload", supplierService.findById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(Supplier supplier, Long id) {
        return null;
    }

}
