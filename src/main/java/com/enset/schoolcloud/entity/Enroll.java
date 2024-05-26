package com.enset.schoolcloud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "enroll")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Enroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enroll_id;
    private String enroll_code;
    private Integer student_id;
    private Integer class_id;
    private Integer section_id;
    private Integer roll;
    private Instant date_added;
    private String year;

}
