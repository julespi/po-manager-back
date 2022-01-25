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

    @NotBlank(message = "Descripcion requerida")
    private String description;

    @NotNull(message = "Precio requerido")
    @Positive(message = "Precio debe no puede ser negativo o cero")
    private Long unitPrice;

    @NotNull(message = "Stock requerido")
    @PositiveOrZero(message = "El stock no puede ser negativo")
    private Integer stock;

    @NotNull(message = "Restock requerido")
    @PositiveOrZero(message = "Restock no puede ser negativo")
    private Integer restock;

    @NotNull(message = "Discontinuo requerido")
    private boolean discontinuous;

    @NotNull(message = "Categoria requerida")
    private Long categoryId;

    @NotNull(message = "Proveedor requerida")
    private Long supplierId;

    private String imageUrl;
}
