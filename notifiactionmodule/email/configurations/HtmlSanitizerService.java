package com.newroztech.dizli.notifiactionmodule.email.configurations;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.springframework.stereotype.Service;

@Service
public class HtmlSanitizerService {
    public String sanitizerHtml(String htmlContent){
        PolicyFactory policy = Sanitizers.FORMATTING
                .and(Sanitizers.BLOCKS)
                .and(Sanitizers.IMAGES)
                .and(Sanitizers.STYLES)
                .and(Sanitizers.LINKS)
                .and(Sanitizers.TABLES);

        String sanitizedHtml = policy.sanitize(htmlContent);

        return sanitizedHtml;
    }
}
