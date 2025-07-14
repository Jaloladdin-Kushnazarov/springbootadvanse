package org.example.springbootadvance.servises;

import org.example.springbootadvance.entity.UserCreateDto;
import org.example.springbootadvance.entity.Users;

public interface UserServise {

    Users creat(UserCreateDto userCreateDto);
}
