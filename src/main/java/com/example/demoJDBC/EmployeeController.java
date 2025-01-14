package com.example.demoJDBC;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeServices employeeServices;

    public  EmployeeController(EmployeeServices employeeServices){
        this.employeeServices = employeeServices;
    }

    @GetMapping()
    public List<Employee> getEmployees(){
        return employeeServices.employees();
    }

    @PostMapping("register")
    public  void registerEmployee(@RequestBody Employee employee){
        employeeServices.registerEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee singleEmployee(@PathVariable int id){
        return  employeeServices.employee(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeServices.deleteEmployee(id);
    }
    @PutMapping("/update/{id}")
    public int updateEmployee(@RequestBody Employee employee,@PathVariable int id){
        return employeeServices.updateEmployee(employee,id);
    }
}
