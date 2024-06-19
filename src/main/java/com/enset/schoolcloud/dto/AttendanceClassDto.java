package com.enset.schoolcloud.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceClassDto {
    private String date;
    private Integer section_id;
    private Integer class_id;
}
