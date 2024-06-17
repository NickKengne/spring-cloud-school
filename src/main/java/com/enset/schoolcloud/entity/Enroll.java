package com.enset.schoolcloud.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "enroll")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class Enroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enroll_id;
    private String enroll_code;
    private Integer class_id;
    private Integer section_id;
    private Integer roll;
    private Instant date_added;
    private String year;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
