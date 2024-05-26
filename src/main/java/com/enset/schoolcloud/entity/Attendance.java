package com.enset.schoolcloud.entity;

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
    @JoinColumn(name ="class_id")
    private Classe classe;

    @OneToOne
    @JoinColumn(name ="section_id")
    private Section section;

    @OneToOne
    @JoinColumn(name ="student_id")
    private Student student;

}
