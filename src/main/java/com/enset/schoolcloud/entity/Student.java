package com.enset.schoolcloud.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;
    private String student_code;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String birthday;
    private String at;
    private String sex;
    private String address;
    private String year;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name ="parent_id")
    private Parent parent;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "class_id")
    private Classe classe;
}
