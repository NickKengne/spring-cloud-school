package com.enset.schoolcloud.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "class")
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer class_id;
    private String name;
    private Integer cycle;
    private String name_numeric;
    private Integer teacher_id;



}
