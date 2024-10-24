package com.fia.df_validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class DynamicRequestValidator implements Validator {
    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;


    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        try {
            JsonNode requestBody = objectMapper.valueToTree(target);
            String configJson = fetchConfigurationFromDb();
            JsonNode validationRules = objectMapper.readTree(configJson);
            validationRules.fields().forEachRemaining(entry -> {
                String field = entry.getKey();
                JsonNode fieldRules = entry.getValue();
                JsonNode value = requestBody.get(field);


                if (fieldRules.has("required") && fieldRules.get("required").asBoolean() && (value == null || value.isNull())) {
                    errors.rejectValue(field, "field.required", field + " is required");
                }

                if (value != null && !value.isNull()) {
                    validateField(field, value, fieldRules, errors);
                }
            });
        }catch (Exception e){
            errors.reject("Validation Failed", "Field to perform validation: " + e.getMessage());
        }
    }

    private void validateField(String field, JsonNode value, JsonNode rules, Errors errors) {
        if (rules.has("type")) {
            validateType(field, value, rules.get("type").asText(), errors);
        }

        if (rules.has("minLength")) {
            int minLength = rules.get("minLength").asInt();
            if (value.asText().length() < minLength) {
                errors.rejectValue(field, "field.minLength", field + " must be at least " + minLength + " characters long");
            }
        }

        // Add more validation rules here (maxLength, pattern, enum, etc.)
    }

    private void validateType(String field, JsonNode value, String type, Errors errors) {
        switch (type) {
            case "string":
                if (!value.isTextual()) {
                    errors.rejectValue(field, "field.type", field + " must be a string");
                }
                break;
            case "number":
                if (!value.isNumber()) {
                    errors.rejectValue(field, "field.type", field + " must be a number");
                }
                break;
        }
    }


    private String fetchConfigurationFromDb() {
        return jdbcTemplate.queryForObject("select config from config", String.class);
    }
}

