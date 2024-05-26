package com.enset.schoolcloud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "section")
@Entity
@Getter
@Setter
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer section_id;
    private String name;

    @OneToOne
    @JoinColumn(name = "class_id")
    private Classe classe;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


}
