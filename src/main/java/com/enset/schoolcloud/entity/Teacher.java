package com.enset.schoolcloud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    private String type;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "class_id")
    private Classe classe;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "section_id")
    private Section section;
}

