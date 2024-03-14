package com.newroztech.dizli.notifiactionmodule.email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    private Integer id;

    private Boolean active = false;

    @NotNull
    private String subject;

    @Column(columnDefinition = "TEXT")
    @NotNull
    private String content;

}
