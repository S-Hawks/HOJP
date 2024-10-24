package com.fia.df_validation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class DynamicFormConfig {
    @Id
    private Long id;
}
