package com.fia.df_validation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormConfigService {
    private final FormConfigRepository formConfigRepository;

    @Transactional
    public FormConfig createFormConfig(FormConfig form) {
        FormConfig formConfig = new FormConfig();
        formConfig.setForm(form.getForm());
        return formConfigRepository.save(formConfig);

    }
}
