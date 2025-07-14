package org.example.springbootadvance.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootadvance.entity.UserCreateDto;
import org.example.springbootadvance.entity.Users;
import org.example.springbootadvance.servises.CacheServise;
import org.example.springbootadvance.servises.MailServise;
import org.example.springbootadvance.servises.impl.UserServiseImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiseImpl userServise;
    private final MailServise mailServise;
    private final CacheServise cacheServise;


    @PostMapping
    public ResponseEntity<Users> create(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userServise.creat(userCreateDto));
    }

    @PostMapping("/smtp/on-off")
    public ResponseEntity<Boolean> turnOnOffSMTPServer() {
        return ResponseEntity.ok(mailServise.turnOnOffSMTPServer());
    }

    @GetMapping
    public ResponseEntity<ConcurrentHashMap<Object, Map<Object, Object>>> getCache() {
        return ResponseEntity.ok(cacheServise.getCache());
    }

}
