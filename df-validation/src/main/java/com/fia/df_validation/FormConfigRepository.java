package com.fia.df_validation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormConfigRepository extends JpaRepository<FormConfig, String> {
}
