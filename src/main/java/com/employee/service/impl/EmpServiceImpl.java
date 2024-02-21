package com.employee.service.impl;

import com.employee.dto.EmpAddress;
import com.employee.dto.EmpDto;
import com.employee.exceptions.ResourceNotFoundException;
import com.employee.repository.AddressRepository;
import com.employee.repository.EmpRepository;
import com.employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpRepository empRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public EmpDto createEmployee(EmpDto employee) {
        EmpDto savedEmployee = empRepository.save(employee);

        // Iterate over addresses and set employee reference
        for (EmpAddress address : savedEmployee.getAddresses()) {
            address.setEmployee(savedEmployee);
        }

        // Save addresses
        for (EmpAddress address : savedEmployee.getAddresses()) {
            addressRepository.save(address);
        }

        return savedEmployee;
    }

    @Override
    public EmpDto getEmployeeById(Integer id) {
        return empRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
    }

    @Override
    public List<EmpDto> getAllEmployees() {
        return empRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        empRepository.deleteById(id);
    }

    @Override
    public EmpDto updateEmployeeById(Integer id, EmpDto employee) {



        if (id == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }

        EmpDto savedEmployee = empRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));

        // Update employee information
        savedEmployee.setName(employee.getName());
        savedEmployee.setEmail(employee.getEmail());
        savedEmployee.setDob(employee.getDob());
        savedEmployee.setPhone(employee.getPhone());
        savedEmployee.setDepartment(employee.getDepartment());
        savedEmployee.setPassword(employee.getPassword());
        savedEmployee.setSalary(employee.getSalary());

        // Update address information
//        List<EmpAddress> updatedAddresses = new ArrayList<>();
//        for (EmpAddress address : employee.getAddresses()) {
//            EmpAddress existingAddress = addressRepository.findById(address.getEmpAddressId())
//                    .orElseThrow(() -> new ResourceNotFoundException("Address not found with ID: " + address.getEmpAddressId()));
//            // Update address fields
//            existingAddress.setPostalCode(address.getPostalCode());
//            existingAddress.setCity(address.getCity());
//            existingAddress.setState(address.getState());
//            existingAddress.setCountry(address.getCountry());
//            // Add the updated address to the list
//            updatedAddresses.add(existingAddress);
//        }
//        // Set the updated addresses to the employee
//        savedEmployee.setAddresses(updatedAddresses);

        // Save the updated employee
        return empRepository.save(savedEmployee);
    }

}


