package com.st.academy.pomanager.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CrudRestController<T> {
    
    @PostMapping("")
    public ResponseEntity<Map<String, Object>> create(@RequestBody T t);

}
