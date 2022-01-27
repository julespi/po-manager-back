package com.st.academy.pomanager.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.st.academy.pomanager.models.entities.ProductDTO;
import com.st.academy.pomanager.models.entities.SupplierDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.st.academy.pomanager.models.entities.Supplier;
import com.st.academy.pomanager.models.services.SupplierService;

@CrossOrigin(origins = {"http://localhost:3000", "https://po-manager-front.herokuapp.com"})
@RestController
@RequestMapping("/api/suppliers")
public class SupplierRestController implements CrudRestController<SupplierDTO> {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Map<String, Object>> create(SupplierDTO supplierDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> findAll(int page, int size, String filter) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        List<SupplierDTO> suppliersDTO = supplierService.findAll()
                .stream()
                .map(supplier -> modelMapper.map(supplier, SupplierDTO.class))
                .collect(Collectors.toList());
        response.put("payload", suppliersDTO);
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
    public ResponseEntity<Map<String, Object>> update(SupplierDTO supplierDTO, Long id) {
        return null;
    }


}
