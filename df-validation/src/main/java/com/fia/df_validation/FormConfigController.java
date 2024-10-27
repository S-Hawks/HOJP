package com.fia.df_validation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FormConfigController {
    private final FormConfigService formConfigService;

    @PostMapping(value = "/api/v1/create-form-config")
    public ResponseEntity<FormConfig> createFormConfig(@RequestBody FormConfig formConfig) {
        formConfigService.createFormConfig(formConfig);
        return ResponseEntity.ok(formConfig);
    }
}
