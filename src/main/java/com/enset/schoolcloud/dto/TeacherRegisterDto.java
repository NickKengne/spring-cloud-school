package com.enset.schoolcloud.dto;

import lombok.Data;

@Data
public class TeacherRegisterDto extends RegisterDto{
    private String surname;
    private String birthday;
    private String at;
    private String sex;
    private  String high_diploma;
    private String speciality;
    private String statut;
    private Integer class_id;
    private Integer section_id;

}
