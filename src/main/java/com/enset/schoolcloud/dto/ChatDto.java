package com.enset.schoolcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChatDto {
    private String name;
    private String message;
    private Integer receiver_id;
    private Integer admin_id;
    private Integer teacher_id;
}
