package com.fia.backend.dto;

import com.fia.backend.ItemStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdateItemResource {

    @NotBlank
    private  String description;

    @NotNull
    private  ItemStatus status;
}
