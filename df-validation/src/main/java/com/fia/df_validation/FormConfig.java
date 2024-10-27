package com.fia.df_validation;

import com.fia.df_validation.models.Form;
import com.fia.df_validation.models.JsonConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class FormConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String formId;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private Form form;


}
