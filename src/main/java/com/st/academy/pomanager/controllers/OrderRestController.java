package com.st.academy.pomanager.controllers;

import com.st.academy.pomanager.models.entities.*;
import com.st.academy.pomanager.models.services.OrderDetailService;
import com.st.academy.pomanager.models.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/orders")
public class OrderRestController implements CrudRestController<OrderDTO> {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Map<String, Object>> create(OrderDTO orderDTO) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Order successfully created");
        Order savedOrder = orderService.save(modelMapper.map(orderDTO, Order.class));
        response.put("payload", modelMapper.map(savedOrder, OrderDTO.class));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Map<String, Object>> findAll(int page, int size, String filter) {
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


    @DeleteMapping("/{id}/detail")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        orderDetailService.delete(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Deletion successfull");
        response.put("payload", null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}
