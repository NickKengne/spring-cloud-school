package com.enset.schoolcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SectionDto {
    private String name;
    private Integer class_id;
    private Integer teacher_id;
}
