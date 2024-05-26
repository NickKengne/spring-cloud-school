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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer admin_id;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role type = Role.ADMIN;
    private String phone;



    enum Role {
        ADMIN,
        TEACHER,
        SUPER_ADMIN
    }

}
