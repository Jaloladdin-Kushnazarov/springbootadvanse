package org.example.springbootadvance.controller;

import java.io.Serializable;

/**
 * DTO for {@link org.example.springbootadvance.entity.Users}
 */
public record UserCreateDto(String username, String password, String email) implements Serializable {
}