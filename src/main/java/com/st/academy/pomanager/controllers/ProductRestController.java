package com.st.academy.pomanager.controllers;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.st.academy.pomanager.models.entities.Product;
import com.st.academy.pomanager.models.entities.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.st.academy.pomanager.models.services.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductRestController implements CrudRestController<ProductDTO> {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        List<ProductDTO> productDTOs = productService.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
        response.put("payload", productDTOs);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> findById(Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        response.put("payload", modelMapper.map(productService.findById(id), ProductDTO.class));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(ProductDTO productDTO, Long id) {
        Product updateInformation = modelMapper.map(productDTO, Product.class);
        Product updatedProduct = productService.update(updateInformation, id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product successfully updated");
        response.put("payload", modelMapper.map(updatedProduct, ProductDTO.class));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> create(ProductDTO productDTO) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product successfully created");
        Product savedProduct = productService.save(modelMapper.map(productDTO, Product.class));
        response.put("payload", modelMapper.map(savedProduct, ProductDTO.class));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
