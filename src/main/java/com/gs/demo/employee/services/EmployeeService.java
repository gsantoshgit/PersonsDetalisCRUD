package com.gs.demo.employee.services;

import java.util.List;

import com.gs.demo.employee.entity.Employee;
import com.gs.demo.employee.exceptions.EmployeeObjExecptions;
 
/**
 * @author Santosh Chary Gadepally
 *
 */
public interface EmployeeService {
	
 public List<Employee> retrieveEmployees();
  
 public Employee getEmployee(Long employeeId)throws EmployeeObjExecptions;
  
 public void saveEmployee(Employee employee);
  
 public void deleteEmployee(Long employeeId);
  
 public void updateEmployee(Employee employee);
}