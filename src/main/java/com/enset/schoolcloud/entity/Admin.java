package com.enset.schoolcloud.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "admin")
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role = Role.ADMIN;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses courses;

    enum Role {
        ADMIN,
        TEACHER,
        SUPER_ADMIN
    }

}
