package com.enset.schoolcloud.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClasseDto {
    private Integer class_id;
    private String name;
    private Integer cycle;
    private String name_numeric;
    private Integer teacher_id;

}
