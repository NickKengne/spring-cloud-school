package com.enset.schoolcloud.controller;

import com.enset.schoolcloud.repository.AttendanceRepository;
import com.enset.schoolcloud.response.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/attendance",produces = MediaType.APPLICATION_JSON_VALUE)
public class AttendanceController {
        public final AttendanceRepository attendanceRepository;


    @PostMapping("/create/{class_id}/{section_id}")
    public ResponseEntity<NotificationResponse> create (@PathVariable("class_id") Integer class_id , @PathVariable("section_id") Integer section_id){
        return ResponseEntity.ok(NotificationResponse.builder().build());
    }
}
