package com.st.academy.pomanager.controllers;

import com.st.academy.pomanager.models.entities.CategoryDTO;
import com.st.academy.pomanager.models.entities.SupplierDTO;
import com.st.academy.pomanager.models.services.CategoryService;
import com.st.academy.pomanager.models.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/categories")
public class CategoryRestController implements CrudRestController<CategoryDTO> {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Map<String, Object>> create(CategoryDTO supplierDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> findAll(int page, int size, String filter) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        List<CategoryDTO> categoriesDTO = categoryService.findAll()
                .stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
        response.put("payload", categoriesDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> findById(Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        response.put("payload", categoryService.findById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(CategoryDTO categoryDTO, Long id) {
        return null;
    }


}
