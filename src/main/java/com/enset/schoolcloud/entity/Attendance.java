package com.enset.schoolcloud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "attendance")
@Getter
@Setter

public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendance_id;
    private String timestamp;
    private String year;
    private Integer status;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name ="class_id")
    private Classe classe;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name ="section_id")
    private Section section;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name ="student_id")
    private Student student;

}
