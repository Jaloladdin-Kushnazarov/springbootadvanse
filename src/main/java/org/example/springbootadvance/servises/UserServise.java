package org.example.springbootadvance.servises;

import org.example.springbootadvance.controller.UserCreateDto;
import org.example.springbootadvance.entity.Users;

public interface UserServise {

    Users creat(UserCreateDto userCreateDto);
}
