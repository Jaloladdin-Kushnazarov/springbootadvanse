package org.example.springbootadvance.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootadvance.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TaskRepository {

    private final JdbcTemplate jdbcTemplate;
    private final static String SELECT_TACK_QUERY = "SELECT * FROM task";

    public List<Task> findAll() {
        return jdbcTemplate.query(SELECT_TACK_QUERY, BeanPropertyRowMapper.newInstance(Task.class));
    }
}
