package com.enset.schoolcloud.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse<T> {
    private String token;
    private Boolean error;
    private Boolean success;
    private String message;
    private Integer id;
    private T user;
}
