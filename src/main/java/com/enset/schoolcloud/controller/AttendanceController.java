package com.enset.schoolcloud.controller;

import com.enset.schoolcloud.dto.AttendanceDto;
import com.enset.schoolcloud.repository.AttendanceRepository;
import com.enset.schoolcloud.response.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/attendance",produces = MediaType.APPLICATION_JSON_VALUE)
public class AttendanceController {
        public final AttendanceRepository attendanceRepository;


    @PostMapping("/create/{class_id}/{section_id}")
    public ResponseEntity<?> create (@PathVariable("class_id") Integer class_id , @PathVariable("section_id") Integer section_id, @RequestBody AttendanceDto attendanceDto){

        return ResponseEntity.ok(attendanceDto);
    }
}
