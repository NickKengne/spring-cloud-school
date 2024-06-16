package com.enset.schoolcloud.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Integer class_id;
    private Integer student_id;
    private Integer section_id;


    /*
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
    @JoinColumn(name ="section_id")
    private Section section;
     */
}
