package com.enset.schoolcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {
    private String name;
    private String date;
    private String year;
    private String comment;
}
