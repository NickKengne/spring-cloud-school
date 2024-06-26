package com.enset.schoolcloud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mark_moy")
@Getter
@Setter
@Builder
public class Mark_Moy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moy_id;
    private Float moy;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "class_id")
    private Classe classe;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @OneToOne
    @JoinColumn(name ="section_id")
    private Section section;
}
