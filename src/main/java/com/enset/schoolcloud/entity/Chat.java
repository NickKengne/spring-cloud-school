package com.enset.schoolcloud.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Table(name = "chat")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chat_id;
    private String name;
    private String message;
    private Integer receiver_id;
    private Timestamp timestamp;


    @OneToOne
    @JoinColumn(name ="admin_id")
    private Admin admin;

    @OneToOne
    @JoinColumn(name ="teacher_id")
    private Teacher teacher;


}
