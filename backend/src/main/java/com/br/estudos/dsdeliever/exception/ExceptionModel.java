package com.br.estudos.dsdeliever.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class ExceptionModel {
    private int code;

    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private List<String> errors;

    public static class Builder{

        private int code;

        private String status;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDateTime timestamp;

        private String message;

        private List<String> errors;

        public Builder(){
        }

        public Builder setCode(int code) {
            this.code = code;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setErrors(List<String> errors) {
            this.errors = errors;
            return this;
        }

        public ExceptionModel build(){
            return new ExceptionModel(this);
        }

    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    private ExceptionModel(Builder builder){
        this.code = builder.code;
        this.status = builder.status;
        this.timestamp = builder.timestamp;
        this.message = builder.message;
        this.errors = builder.errors;

    }
}
