package com.enset.schoolcloud.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String sex;
    private String at;
    private String higher_diploma;
    private String statut;
    private String birthday;

}
