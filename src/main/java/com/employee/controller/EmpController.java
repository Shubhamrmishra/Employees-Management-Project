package com.employee.controller;

import com.employee.dto.EmpAddress;
import com.employee.dto.EmpDto;
import com.employee.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/employees")
public class EmpController {

    @Autowired
    EmpService empService;


        @PostMapping("/save")
        public ResponseEntity<?> createEmployee(@RequestBody EmpDto employee){
            try {
                EmpDto savedEmployee = empService.createEmployee(employee);
                return ResponseEntity.ok(savedEmployee);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while saving the employee: " + e.getMessage());
            }
        }

        @GetMapping("/{id}")
        public EmpDto getEmployee(@PathVariable Integer id) {
            return empService.getEmployeeById(id);
        }

        @CrossOrigin("http://localhost:4200/")
        @GetMapping("/")
        public List<EmpDto> getAllEmployees() {
            return empService.getAllEmployees();
        }

        @DeleteMapping("/{id}")
        public void deleteEmployee(@PathVariable Integer id) {
            empService.deleteEmployeeById(id);
        }

        @PutMapping("/{id}")
        public EmpDto updateEmployee(@PathVariable Integer id,@RequestBody EmpDto empDto){
            return empService.updateEmployeeById(id,empDto);
        }

        @GetMapping("/home")
        public String getHome(){
            return "home";
        }



}

