package com.challenge.crud.crud.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
    private List<FieldMessage> listErros = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getListErros() {
        return listErros;
    }

    public void addError(String fieldName, String message) {
        listErros.add(new FieldMessage(fieldName, message));
    }
}
