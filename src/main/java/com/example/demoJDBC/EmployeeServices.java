package com.example.demoJDBC;

import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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

    public void registerEmployee(@NotNull Employee employee){
        //  ? is placeholders for name , position , salary
        String mutation = "INSERT INTO employee  (name, position, salary)  values(?,?,?)";
        jdbcTemplate.update(mutation,employee.getName(),employee.getPosition(),employee.getSalary());
    }

    public Employee employee(@NotNull int id){
        String query = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<>(Employee.class));
    }
}
