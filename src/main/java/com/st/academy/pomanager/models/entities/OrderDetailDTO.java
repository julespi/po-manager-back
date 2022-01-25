package com.st.academy.pomanager.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class OrderDetailDTO extends BasePersistanceDTO{

    @NotNull(message = "El id del producto es requerido")
    private Long productId;

    @NotNull(message = "La cantidad es requerida")
    private Integer quantity;

    @NotNull(message = "El precio de venta del producto es requerido")
    private Integer unitSalePrice;

}
