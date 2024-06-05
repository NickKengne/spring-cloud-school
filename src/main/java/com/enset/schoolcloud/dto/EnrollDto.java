package com.enset.schoolcloud.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollDto {
    private String enroll_code;
    private Integer student_id;
    private Integer class_id;
    private Integer section_id;
    private Integer roll;
    private Instant date_added;
    private String year;
}
