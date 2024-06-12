package com.enset.schoolcloud.controller;


import com.enset.schoolcloud.dto.NotificationDto;
import com.enset.schoolcloud.entity.Notification;
import com.enset.schoolcloud.repository.NotificationRepository;
import com.enset.schoolcloud.response.NotificationResponse;
import com.enset.schoolcloud.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/notification", produces = MediaType.APPLICATION_JSON_VALUE)
public class NotificationController {
    private final NotificationRepository notificationRepository;
    private final NotificationService notificationService;


    @PostMapping("/create")
    public ResponseEntity<NotificationResponse> create (@RequestBody NotificationDto notificationDto){
        return ResponseEntity.ok(notificationService.create(notificationDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Notification>> getAllNotification (){
        return ResponseEntity.ok(notificationRepository.findAll());
    }

    @DeleteMapping("/{notification_id}")
    public ResponseEntity<NotificationResponse> delete (@PathVariable("notification_id") Integer notification_id){
        notificationRepository.deleteById(notification_id);
        return ResponseEntity.ok(NotificationResponse.builder()
                        .message("Notifcation deleted successfully !")
                        .success(true)
                        .error(false)
                .build());
    }
}
