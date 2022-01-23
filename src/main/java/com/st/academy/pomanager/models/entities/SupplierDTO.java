package com.st.academy.pomanager.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
public class SupplierDTO extends BasePersistanceDTO{

    @NotBlank(message = "Company is required")
    private String company;

    @NotBlank(message = "Contact is required")
    private String contact;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "categoryId is required")
    private Long categoryId;
}
