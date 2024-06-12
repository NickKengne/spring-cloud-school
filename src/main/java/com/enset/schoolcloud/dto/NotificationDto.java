package com.enset.schoolcloud.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {
    private String notif;
    private Integer admin_id;
    private Integer teacher_id;
    private String diffusion;
}
