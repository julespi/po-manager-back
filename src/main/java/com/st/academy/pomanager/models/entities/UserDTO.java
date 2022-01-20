package com.st.academy.pomanager.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDTO extends BasePersistanceDTO{

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String role;

    private Integer managerId;
}
