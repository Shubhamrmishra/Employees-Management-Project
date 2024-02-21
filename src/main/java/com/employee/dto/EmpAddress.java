package com.employee.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Employees_address")
public class EmpAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_address_id")
    private Integer empAddressId;

    @Column(name = "emp_postal_code")
    private long postalCode;

    @Column(name = "emp_city")
    private String city;

    @Column(name = "emp_state")
    private String state;

    @Column(name = "emp_country")
    private String country;

    @ManyToOne
    @JsonBackReference
    private EmpDto employee;
}
