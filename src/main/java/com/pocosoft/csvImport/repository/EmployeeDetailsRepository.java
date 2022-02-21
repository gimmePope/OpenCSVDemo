package com.pocosoft.csvImport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pocosoft.csvImport.model.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long>{

}
