package com.enset.schoolcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {
    private String name;
    private Integer coef;
    private String code;
    private String year;
    private Integer section_id;
    private Integer class_id;
    private Integer teacher_id;
}
