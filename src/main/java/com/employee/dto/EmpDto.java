package com.employee.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Employees_details")
public class EmpDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Integer id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_email")
    private String email;

    @Column(name = "emp_department")
    private String department;

    @Column(name = "emp_dob")
    private Date dob;

    @Column(name = "emp_password")
    private String password;

    @Column(name = "emp_phone")
    private long phone;

    @Column(name = "emp_salary")
    private Long salary;


    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private List<EmpAddress> addresses;


}
