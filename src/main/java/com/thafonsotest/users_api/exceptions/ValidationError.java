package com.thafonsotest.users_api.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private LocalDateTime timestamp;
    private int status;
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(int status) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }

    public void addError(String field, String message) {
        errors.add(new FieldMessage(field, message));
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldMessage> errors) {
        this.errors = errors;
    }
}
