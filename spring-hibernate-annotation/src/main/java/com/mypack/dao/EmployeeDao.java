package com.mypack.dao;

import java.util.List;

import com.mypack.hibernate.entities.Employee;

public interface EmployeeDao {
    List<Employee> findEmployees();

    void deleteEmployees(List<Employee> empList);

    void createEmployee(Employee employee);

    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    
}
