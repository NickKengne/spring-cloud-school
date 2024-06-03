package com.enset.schoolcloud.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "mark")
@Builder
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float test2;
    private Float exam;
    private Float mark_obtained;
    private String year;
    private String comment;



    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "exam_id")
    private Exam examen;

    @OneToOne
    @JoinColumn(name ="subject_id")
    private Subject subject;

    @OneToOne
    @JoinColumn(name ="class_id")
    private Classe classe;

    @OneToOne
    @JoinColumn(name ="section_id")
    private Section section;



}
