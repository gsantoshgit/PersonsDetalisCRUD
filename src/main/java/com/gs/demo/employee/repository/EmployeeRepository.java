package com.gs.demo.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gs.demo.employee.entity.Employee;
 
/**
 * @author Santosh Chary Gadepally
 *
 */
 
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
 
}