package com.fia.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NewItemResource {

    @NotBlank
    private String description;
}
