package com.st.academy.pomanager.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDTO extends BasePersistanceDTO{

    @NotNull(message = "El id del cliente es requerido")
    private Long clientId;

    private Long employeeId;

    private Date delivered;

    @NotNull
    private Boolean isOpen;

    private List<OrderDetailDTO> details;

}
