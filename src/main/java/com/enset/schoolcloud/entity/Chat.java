package com.enset.schoolcloud.entity;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;

@Table(name = "chat")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chat_id;
    private String name;
    private String message;
    private Integer receiver_id;
    private Instant timestamp;
    private Integer admin_id;
    private Integer teacher_id;


}
