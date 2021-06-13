package com.gs.demo.employee.services;

import java.util.List;

import com.gs.demo.employee.entity.Employee;
import com.gs.demo.employee.exceptions.EmployeeObjExecptions;
 
/**
 * @author Santosh Chary Gadepally
 *
 */
public interface EmployeeService {
	
 public List<Employee> retrieveEmployees()throws EmployeeObjExecptions;
  
 public Employee getEmployee(Long employeeId)throws EmployeeObjExecptions;
  
 public void saveEmployee(Employee employee)throws EmployeeObjExecptions;
  
 public void deleteEmployee(Long employeeId)throws EmployeeObjExecptions;
  
 public void updateEmployee(Employee employee)throws EmployeeObjExecptions;
}
