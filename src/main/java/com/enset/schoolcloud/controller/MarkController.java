package com.enset.schoolcloud.controller;


import com.enset.schoolcloud.repository.MarkRepository;
import com.enset.schoolcloud.response.MarkDto;
import com.enset.schoolcloud.response.MarkResponse;
import com.enset.schoolcloud.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mark", produces = MediaType.APPLICATION_JSON_VALUE)
public class MarkController {
    private final MarkService markService;
    private final MarkRepository markRepository;


    @PostMapping("/insert")
    public ResponseEntity<MarkResponse> insertMark (@RequestBody List<MarkDto> markDto){
        return ResponseEntity.ok(markService.insertMark(markDto));
    }

    @DeleteMapping("/{mark_id}")
    public ResponseEntity<String> deleteMarks (@PathVariable("mark_id") Integer markId){
        var thisMark = markRepository.findById(markId).orElseThrow(()  -> new RuntimeException("Mark no found"));
        markRepository.deleteById(markId);
        return ResponseEntity.ok("Mark deleted successfully");
    }
}
