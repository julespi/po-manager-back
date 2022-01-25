package com.st.academy.pomanager.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface CrudRestController<T> {

    @PostMapping("")
    ResponseEntity<Map<String, Object>> create(@Valid @RequestBody T t);

    @GetMapping("")
    ResponseEntity<Map<String, Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "") String filter);

    @GetMapping("/{id}")
    ResponseEntity<Map<String, Object>> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Map<String, Object>> update(@Valid @RequestBody T t, @PathVariable Long id);
}
