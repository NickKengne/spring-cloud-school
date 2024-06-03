package com.enset.schoolcloud.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Subject")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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


