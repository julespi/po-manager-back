package com.st.academy.pomanager.controllers;

import com.st.academy.pomanager.models.entities.OrderDTO;
import com.st.academy.pomanager.models.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/orders")
public class OrderRestController implements CrudRestController<OrderDTO> {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Map<String, Object>> create(OrderDTO supplierDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        List<OrderDTO> ordersDTO = orderService.findAll()
                .stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
        response.put("payload", ordersDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> findById(Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        response.put("payload", orderService.findById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(OrderDTO supplierDTO, Long id) {
        return null;
    }


}
