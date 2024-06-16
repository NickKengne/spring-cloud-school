package com.enset.schoolcloud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "exam_id")
    private Exam examen;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name ="subject_id")
    private Subject subject;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name ="class_id")
    private Classe classe;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name ="section_id")
    private Section section;



}
