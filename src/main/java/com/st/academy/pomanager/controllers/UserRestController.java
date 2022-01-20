package com.st.academy.pomanager.controllers;

import com.st.academy.pomanager.models.entities.User;
import com.st.academy.pomanager.models.entities.UserDTO;
import com.st.academy.pomanager.models.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/users")
public class UserRestController implements CrudRestController<UserDTO> {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Map<String, Object>> create(UserDTO userDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        List<UserDTO> categoriesDTO = userService.findAll()
                .stream()
                .map(category -> modelMapper.map(category, UserDTO.class))
                .collect(Collectors.toList());
        response.put("payload", categoriesDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> findById(Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Exist");
        response.put("payload", userService.findById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(UserDTO userDTO, Long id) {
        return null;
    }

    @PostMapping("/login")
    ResponseEntity<Map<String, Object>> login(@Valid @RequestBody UserDTO userDTO){
        User userToLogin = modelMapper.map(userDTO, User.class);
        User logedInUser = userService.login(userToLogin);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User successfully loged in");
        response.put("payload", modelMapper.map(logedInUser, UserDTO.class));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
