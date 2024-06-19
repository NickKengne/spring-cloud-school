package com.enset.schoolcloud.dto;

import com.enset.schoolcloud.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {
    private AttendanceClassDto class_details;
    private AttendanceValueDto attendance;
}
