package com.enset.schoolcloud.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "moy_annuelle")
@Entity
public class Moy_Annuelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moy_id;
    private Float moy_annuelle;
    private String year;


    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "class_id")
    private Classe classe;

    @OneToOne
    @JoinColumn(name ="section_id")
    private Section section;
}
