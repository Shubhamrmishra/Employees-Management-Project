package com.employee.service;

import com.employee.dto.EmpDto;

import java.util.List;

public interface EmpService {


    //  @Transactional
    EmpDto createEmployee(EmpDto employee);

    EmpDto getEmployeeById(Integer id);

    List<EmpDto> getAllEmployees();

    void deleteEmployeeById(Integer id);

    EmpDto updateEmployeeById(Integer id, EmpDto empDto);
}
