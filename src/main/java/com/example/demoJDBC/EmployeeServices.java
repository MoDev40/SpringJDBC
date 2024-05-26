package com.example.demoJDBC;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {
    private  final JdbcTemplate jdbcTemplate;

    public EmployeeServices(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> employees(){
        String query = "SELECT * FROM employee";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Employee.class));
    }
}
