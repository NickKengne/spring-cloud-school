package com.enset.schoolcloud.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Subject")
@Getter
@Setter

public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subject_id;
    private String name;
    private Integer coef;
    private String code;
    private String year;

    @OneToOne
    @JoinColumn(name = "class_id")
    private Classe classe;

    @OneToOne
    @JoinColumn(name = "section_id")
    private Section Section;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}


