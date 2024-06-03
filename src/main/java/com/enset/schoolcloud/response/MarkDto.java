package com.enset.schoolcloud.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {
    private Float test2;
    private Float exam;
    private Float mark_obtained;
    private String year;
    private String comment;
    private Integer student_id;
    private Integer class_id;
    private Integer subject_id;
    private Integer section_id;
    private Integer exam_id;

}
