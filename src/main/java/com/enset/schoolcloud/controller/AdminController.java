package com.enset.schoolcloud.controller;


import com.enset.schoolcloud.dto.LoginDto;
import com.enset.schoolcloud.dto.RegisterDto;
import com.enset.schoolcloud.entity.Admin;
import com.enset.schoolcloud.entity.Teacher;
import com.enset.schoolcloud.repository.AdminRepository;
import com.enset.schoolcloud.response.RegisterResponse;
import com.enset.schoolcloud.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    private final AdminService adminService;
    private final AdminRepository adminRepository;

    @PostMapping("/auth/register")
    public RegisterResponse<Object> register (@RequestBody RegisterDto registerDto){
        return adminService.register(registerDto);
    }

    //implementer le login
    @PostMapping("/auth/login")
    public RegisterResponse<Object>  login(@RequestBody LoginDto loginDto){
        return adminService.login(loginDto);
    }

    @PostMapping("/delete/{admin_id}")
    public ResponseEntity<String> delete (@PathVariable("admin_id") Integer admin_id){
        return ResponseEntity.ok(adminService.delete(admin_id));
    }

    @PutMapping("/update/{admin_id}")
    public ResponseEntity<String> update (@RequestBody RegisterDto registerDto , @PathVariable("admin_id") Integer admin_id){
        return ResponseEntity.ok(adminService.update(admin_id, registerDto));
    }

    @GetMapping("/all")
    public List<Admin> getAll (){
        return adminRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Admin>> getById (@PathVariable("id") Integer id){
        return ResponseEntity.ok(adminRepository.findById(id));
    }
}
