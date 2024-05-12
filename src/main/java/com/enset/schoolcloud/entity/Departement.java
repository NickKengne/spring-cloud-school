package com.enset.schoolcloud.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departement")
@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "departement")
    private List<Classes> classes;
    @OneToOne
    @JoinColumn(name = "head_id")
    private Admin admin;
}
