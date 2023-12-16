package com.example.notes2.common.exeptions.responses;

import lombok.Data;

import java.util.Map;

@Data
public class ValidationExceptionResponse {
    private Map<String, String> errors;
}
