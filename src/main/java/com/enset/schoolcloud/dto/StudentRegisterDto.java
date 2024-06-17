package com.enset.schoolcloud.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class StudentRegisterDto extends RegisterDto{
    private String surname;
    private String birthday;
    private String student_code;
    private String at;
    private String sex;
    private String enroll_code;
    private Integer class_id;
    private Integer section_id;
    private Integer roll;
    private Instant date_added;
    private String year;


}
