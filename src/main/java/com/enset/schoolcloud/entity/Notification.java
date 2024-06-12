package com.enset.schoolcloud.entity;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notification")
@Getter
@Setter
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notification_id;
    private String notif;
    private Integer admin_id;
    private Integer teacher_id;
    private String diffusion;
    private Instant created_at;
}
