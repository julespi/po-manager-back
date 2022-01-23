package com.st.academy.pomanager.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
public class ProductDTO extends BasePersistanceDTO{

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Unit price is required")
    @Positive(message = "unitPrice cannot be negative or zero")
    private Long unitPrice;

    @NotNull(message = "stock is required")
    @PositiveOrZero(message = "stock cannot be negative")
    private Integer stock;

    @NotNull(message = "restock is required")
    @PositiveOrZero(message = "restock cannot be negative")
    private Integer restock;

    @NotNull(message = "discontinuous is required")
    private boolean discontinuous;

    @NotNull(message = "categoryId is required")
    private Long categoryId;

    @NotNull(message = "supplierId is required")
    private Long supplierId;

    private String imageUrl;
}
