package com.enset.schoolcloud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "section")
@Entity
@Getter
@Setter
@Builder
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer section_id;
    private String name;

    @OneToOne
    //@JsonManagedReference
    @JsonBackReference
    @JoinColumn(name = "class_id")
    private Classe classe;

    @OneToOne
    @JsonBackReference
    //@JsonManagedReference
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
