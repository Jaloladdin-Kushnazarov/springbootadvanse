package org.example.springbootadvance.servises.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springbootadvance.controller.UserCreateDto;
import org.example.springbootadvance.entity.Users;
import org.example.springbootadvance.event.OtpGenerateEvent;
import org.example.springbootadvance.mappers.UsersMapper;
import org.example.springbootadvance.repository.UserRepository;
import org.example.springbootadvance.servises.UserServise;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
@RequiredArgsConstructor
public class UserServiseImpl implements UserServise {

    private final UsersMapper usersMapper;
    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;


    @Transactional
    @Override
    public Users creat(UserCreateDto userCreateDto) {
        Users users = usersMapper.fromCreatDto(userCreateDto);
        userRepository.save(users);
        publisher.publishEvent(new OtpGenerateEvent(users));
        return users;
    }
}
