package com.newroztech.dizli.notifiactionmodule;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
    @JsonIgnore
    private int code;
    private String message;
    private List<String> errors = new ArrayList<>();
    private Object data;

    public ApiResponse(int code, String message, List<String> errors) {
        this(code, message, errors, null);
    }

    public ApiResponse(int code, String message) {
        this(code, message, new ArrayList<>());
    }

    public ApiResponse(int code, List<String> errors) {
        this(code, "Error!", errors);
    }

    public ApiResponse(int code, String message, Object data) {
        this(code, message, new ArrayList<>(), data);
    }

    public ApiResponse(String message) {
        this(200, message);
    }
}
