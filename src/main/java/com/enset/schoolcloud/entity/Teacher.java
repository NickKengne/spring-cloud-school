package com.enset.schoolcloud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacher_id;
    private String name;
    private String surname;
    private String birthday;
    private String at;
    private String sex;
    private String higher_diploma;
    private String speciality;
    private String statut;
    private  String address;
    private String phone;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "class_id")
    private Classe classe;

    @OneToOne
    @JoinColumn(name = "section_id")
    private Section section;
}

