package com.enset.schoolcloud.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "class")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer class_id;
    private String name;
    private Integer cycle;
    private String name_numeric;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "teacher_id")
    public Teacher teacher;

    @OneToMany
    public List<Section> sections;

}
