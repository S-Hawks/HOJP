package com.newroztech.dizli.notifiactionmodule.push;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PushTemplateRepository extends JpaRepository<PushTemplate, String> {
}
