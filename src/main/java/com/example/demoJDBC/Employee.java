package com.example.demoJDBC;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
     private int id ;
     private String name;
     private String position;
     private BigDecimal salary;
}
