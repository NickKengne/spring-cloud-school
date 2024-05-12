package com.enset.schoolcloud.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "etudiant")
@Getter
@Setter
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String matricule;
    private String nom;
    private String prenom;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String phone;
    private String dateNaissance;
    private String lieuNaissance;
    private String sexe;

    @OneToOne
    @JoinColumn(name = "class_id")
    private Classes classe;

}
