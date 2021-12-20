package com.st.academy.pomanager.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.academy.pomanager.models.services.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierRestController {
    
    @Autowired
    private SupplierService supplierService;
    
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> list(){
	Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        response.put("payload", supplierService.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable Long id){
	Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        response.put("payload", supplierService.findById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}