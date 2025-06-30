package org.example.springbootadvance.servises.impl;

import lombok.RequiredArgsConstructor;
import org.example.springbootadvance.entity.Users;
import org.example.springbootadvance.repository.UserRepository;
import org.example.springbootadvance.servises.OtpServise;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OtpServiseImpl implements OtpServise {

    private final UserRepository userRepository;

    @Override
    public void otpGenerate(Users users) {
        users.setOtp(UUID.randomUUID().toString());
        userRepository.save(users);
    }
}
