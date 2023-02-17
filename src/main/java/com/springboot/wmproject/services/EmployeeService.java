package com.springboot.wmproject.services;

import com.springboot.wmproject.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getOneEmployeeById(int id);
    EmployeeDTO createEmployee(EmployeeDTO newEmployeeDTO);
    EmployeeDTO updateEmployee(EmployeeDTO updateEmployeeDTO);
    List<EmployeeDTO> findAllByEmpType(String empType);
    List<EmployeeDTO> findAllByName(String empType);
    void deleteEmployee(int employeeId);

}
