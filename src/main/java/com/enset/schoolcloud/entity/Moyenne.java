package com.enset.schoolcloud.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "moyenne")
@Getter
@Setter
@Builder
public class Moyenne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float moyenne;

    @OneToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @OneToOne
    @JoinColumn(name = "class_id")
    private Classes classes;
}
