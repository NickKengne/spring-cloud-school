package com.enset.schoolcloud.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ExamResponseCreate {
    private String message;
    private HttpStatus status;
    private Instant created_at = Instant.now();
}
