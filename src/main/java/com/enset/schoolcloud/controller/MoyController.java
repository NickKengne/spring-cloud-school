package com.enset.schoolcloud.controller;


import com.enset.schoolcloud.entity.Moy_Annuelle;
import com.enset.schoolcloud.repository.MoyRepository;
import com.enset.schoolcloud.service.MoyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/moy", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoyController {
    private MoyRepository moyRepository;
    private MoyService moyService;


    @PostMapping("/generate/moy/{class_id}/{section_id}/{exam_id}")
    public ResponseEntity<List<Moy_Annuelle>> generate_Moy (@PathVariable("class_id") Integer class_id , @PathVariable("section_id") Integer section_id , @PathVariable("exam_id") Integer exam_id){
        List<Moy_Annuelle> moyenne = new ArrayList<>();
        return ResponseEntity.ok(moyenne);
    }

}
