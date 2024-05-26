package com.enset.schoolcloud.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterResponse<T> {
    private String message;
    private Boolean success;
    private Boolean error;
    private String token;
    private Instant created_at;
    private T entity;
}
