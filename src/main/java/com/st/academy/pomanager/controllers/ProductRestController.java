package com.st.academy.pomanager.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.st.academy.pomanager.models.entities.Product;
import com.st.academy.pomanager.models.entities.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.st.academy.pomanager.models.entities.Supplier;
import com.st.academy.pomanager.models.services.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductRestController implements CrudRestController<ProductDTO> {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> list() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        response.put("payload", productService.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        response.put("payload", modelMapper.map(productService.findById(id), ProductDTO.class));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> create(@Valid ProductDTO productDTO) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        Product savedProduct = productService.save(modelMapper.map(productDTO, Product.class));
        response.put("payload", modelMapper.map(savedProduct, ProductDTO.class));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
