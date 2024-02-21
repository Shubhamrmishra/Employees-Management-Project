package com.employee.repository;


import com.employee.dto.EmpAddress;
import com.employee.dto.EmpDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<EmpDto,Integer> {

}
