/**
 *   Copyright 2021 by G Santosh Chary All Rights Reserved.
 *
 *        @filename         : EmployeeRestController.java
 *        @version          : 1.0.0
 *        @date             : March 20, 2021
 *        @description		: This Controller class is used to do the get,put,post request mappings
 *
 *        @author <a href="mailto:santoshchary.gadepally@gmail.com">Santosh Chary Gadepally/a>
 *
 * History of modifications:
 * Author                            Date                Description of modifications
 * ------------                  ------------         ------------------------------
 * Santosh Chary Gadepally   		March 20, 2021            Created.
 **/

package com.gs.demo.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gs.demo.employee.entity.Employee;
import com.gs.demo.employee.exceptions.EmployeeObjExecptions;
import com.gs.demo.employee.serviceimpl.EmployeeServiceImpl;
import com.gs.demo.employee.services.EmployeeService;

@RestController
public class EmployeeRestController {
  
 @Autowired
 private EmployeeService employeeService;
 private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	private static final String CLASS_NAME="EmployeeRestController ::";
  
 public void setEmployeeService(EmployeeService employeeService) {
  this.employeeService = employeeService;
 }
 

 @RequestMapping(value = "/api/allemployees", method = RequestMethod.GET,
			produces = { "application/json" } )
 public List<Employee> getEmployees() {
  List<Employee> employees = employeeService.retrieveEmployees();
  return employees;
 }
  
 @GetMapping("/api/employeeById/{employeeId}")
 public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) throws EmployeeObjExecptions {
	 
	 String METHOD_NAME="retrieveEmployees :";
	 log.info(CLASS_NAME+METHOD_NAME+" Entry");
	 
	 Employee employee=null;
	 try {	 
	 
	 employee=employeeService.getEmployee(employeeId);
	 
	 }catch (Exception e) {
		 log.error(CLASS_NAME+METHOD_NAME+"e.getMessage() ::"+e.getMessage());
		 throw new  EmployeeObjExecptions(e.getMessage());
	}
	 log.info(CLASS_NAME+METHOD_NAME+"Exit");
  return employee;
 }
  
 @PostMapping("/api/addemployee")
 public void saveEmployee(Employee employee){
  employeeService.saveEmployee(employee);
  System.out.println("Employee Saved Successfully");
 }
  
 @DeleteMapping("/api/deleemployee/{employeeId}")
 public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
  employeeService.deleteEmployee(employeeId);
  System.out.println("Employee Deleted Successfully");
 }
  
 @PutMapping("/api/updateemployee/{employeeId}")
 public void updateEmployee(@RequestBody Employee employee,
   @PathVariable(name="employeeId")Long employeeId){
  Employee emp = null;
try {
	emp = employeeService.getEmployee(employeeId);
} catch (EmployeeObjExecptions e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  if(emp != null){
   employeeService.updateEmployee(employee);
  }
   
 }
 
}