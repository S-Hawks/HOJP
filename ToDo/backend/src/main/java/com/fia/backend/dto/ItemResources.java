package com.fia.backend.dto;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Data
public class ItemResources {
    private String description;

    private String version;

    private Instant CreatedDate;

    private Instant updatedDate;
}
