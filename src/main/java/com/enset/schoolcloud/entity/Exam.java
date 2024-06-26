package com.enset.schoolcloud.entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "exam")
@Entity
@Builder
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exam_id;
    private String name;
    private String date;
    private String year;
    private String comment;
}
