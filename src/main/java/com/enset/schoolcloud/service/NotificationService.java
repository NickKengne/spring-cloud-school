package com.enset.schoolcloud.service;

import com.enset.schoolcloud.dto.NotificationDto;
import com.enset.schoolcloud.entity.Notification;
import com.enset.schoolcloud.repository.NotificationRepository;
import com.enset.schoolcloud.response.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationResponse create(NotificationDto notificationDto) {
        var notification = Notification.builder()
                .notif(notificationDto.getNotif())
                .created_at(Instant.now())
                .admin_id(notificationDto.getAdmin_id())
                .teacher_id(notificationDto.getTeacher_id())
                .diffusion(notificationDto.getDiffusion())
                .build();

        notificationRepository.save(notification);
        return NotificationResponse.builder()
                .error(false)
                .success(true)
                .message("Notification created successfully !")
                .build();

    }
}
