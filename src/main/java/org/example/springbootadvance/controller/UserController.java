package org.example.springbootadvance.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootadvance.entity.Users;
import org.example.springbootadvance.servises.impl.UserServiseImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiseImpl userServise;


    @PostMapping
    public ResponseEntity<Users> create(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userServise.creat(userCreateDto));
    }


}
