package com.enset.schoolcloud.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkResponse {
    private HttpStatus status_code;
    private String message;
    private Boolean success;
    private Boolean error;

}
