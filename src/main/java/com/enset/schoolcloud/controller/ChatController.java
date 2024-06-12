package com.enset.schoolcloud.controller;

import com.enset.schoolcloud.dto.ChatDto;
import com.enset.schoolcloud.entity.Chat;
import com.enset.schoolcloud.repository.ChatRepository;
import com.enset.schoolcloud.response.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/chat",produces = MediaType.APPLICATION_JSON_VALUE)
public class ChatController {


    private final ChatRepository chatRepository;

    @PostMapping("/send")
    public ResponseEntity<NotificationResponse> sendMessage (@RequestBody ChatDto chatDto){
        var message = Chat.builder()
                .timestamp(Instant.now())
                .message(chatDto.getMessage())
                .admin_id(chatDto.getAdmin_id())
                .teacher_id(chatDto.getTeacher_id())
                .receiver_id(chatDto.getReceiver_id())
                .build();
        chatRepository.save(message);
        return ResponseEntity.ok(NotificationResponse.builder()
                        .success(true)
                        .error(false)
                        .message("Message sent successfully !")
                .build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Chat>> getAll (){
        return ResponseEntity.ok(chatRepository.findAll());
    }

}
