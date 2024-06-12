package com.enset.schoolcloud.response;

import codex.bookerapi.entity.entreprise.Entreprise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private Boolean error;
    private Boolean success;
    private String message;
    private String id;
    private Entreprise enterprise;
}
