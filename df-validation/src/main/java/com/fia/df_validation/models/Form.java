package com.fia.df_validation.models;


import java.util.List;

public record Form(
        List<Fields> fields,
        List<Buttons> buttons,
        List<Groups> groups
) {

    public record Fields(
            String fieldName,
            String title,
            String placeHolder,
            String type,
            String defaultValue,
            String state,
            String action,
            String groupId,
            String position,
            String min,
            String max,
            String required,
            String parentParam,
            String fetchData,
            String validator,
            String options
    ) {
    }

    public record Buttons(
            String type,
            String name,
            String api
    ) {
    }

    public record Groups(
            String id,
            String title,
            String subtitle
    ) {
    }
}
