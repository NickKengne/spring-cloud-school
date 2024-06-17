package com.enset.schoolcloud.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "class_id")
    private Classe classe;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "section_id")
    private Section Section;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}


