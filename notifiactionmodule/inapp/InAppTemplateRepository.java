package com.newroztech.dizli.notifiactionmodule.inapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InAppTemplateRepository extends JpaRepository<InAppTemplate, String> {
}
