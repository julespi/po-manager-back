package com.st.academy.pomanager.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryDTO extends BasePersistanceDTO{

    @NotBlank(message = "Description is required")
    private String description;
}
