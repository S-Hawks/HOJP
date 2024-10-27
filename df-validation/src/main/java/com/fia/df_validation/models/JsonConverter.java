package com.fia.df_validation.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class JsonConverter implements AttributeConverter<Form, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Form form) {
        try {
            return form == null ? null : objectMapper.writeValueAsString(form);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Field to convert form to JSON string: " + e);
        }
    }

    @Override
    public Form convertToEntityAttribute(String dbData) {
        try {
            return dbData == null ? null : objectMapper.readValue(dbData, Form.class);

        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Field to convert form to JSON string: " + e);
        }
    }
}
