package com.enset.schoolcloud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float cc;
    private Float normale;


    @OneToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @OneToOne
    @JoinColumn(name = "courses_id")
    private Courses courses;

    @OneToOne
    @JoinColumn(name = "exam_type_id")
    private ExamType examType;

}
