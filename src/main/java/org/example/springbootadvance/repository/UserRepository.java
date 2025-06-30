package org.example.springbootadvance.repository;

import org.example.springbootadvance.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}