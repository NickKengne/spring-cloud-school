package com.enset.schoolcloud.controller;


import com.enset.schoolcloud.repository.MoyRepository;
import com.enset.schoolcloud.service.MoyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/moy", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoyController {
    private MoyRepository moyRepository;
    private MoyService moyService;


}
