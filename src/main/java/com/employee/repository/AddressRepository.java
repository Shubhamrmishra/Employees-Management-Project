package com.employee.repository;

import com.employee.dto.EmpAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<EmpAddress,Integer> {
}
