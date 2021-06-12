/**
 *   Copyright 2021 by G Santosh Chary All Rights Reserved.
 *
 *        @filename         : EmployeeServiceImpl.java
 *        @version          : 1.0.0
 *        @date             : March 20, 2021
 *        @description		: This class is used to do all crud operation on employee object
 *
 *        @author <a href="mailto:santoshchary.gadepally@gmail.com">Santosh Chary Gadepally/a>
 *
 * History of modifications:
 * Author                            Date                Description of modifications
 * ------------                  ------------         ------------------------------
 * Santosh Chary Gadepally   		March 20, 2021            Created.
 **/
package com.gs.demo.employee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.gs.demo.employee.entity.Employee;
import com.gs.demo.employee.exceptions.EmployeeObjExecptions;
import com.gs.demo.employee.repository.EmployeeRepository;
import com.gs.demo.employee.services.EmployeeService;

 

@Component
public class EmployeeServiceImpl implements EmployeeService{
 
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	private static final String CLASS_NAME="EmployeeServiceImpl ::";
	
 @Autowired
 private EmployeeRepository employeeRepository;


 
 /**
* @param employeeRepository 
* This method is used to set the Repository 
*/
 
 public void setEmployeeRepository(EmployeeRepository employeeRepository) {
	 log.info(CLASS_NAME+" :: Entry");
  this.employeeRepository = employeeRepository;
 log.info("Exit");
 }
 /**
* This API method is to retrieve the List of employees
*/ 
 public List<Employee> retrieveEmployees() {
	 String METHOD_NAME="retrieveEmployees :";
 log.info(CLASS_NAME+METHOD_NAME+" Entry");
  List<Employee> employees = employeeRepository.findAll();
 log.info(CLASS_NAME+METHOD_NAME+"Exit");
  return employees;
 }
 
 /**
* This API method is to the getEmployee based on provided id
* @param employeeId
*/ 
 public Employee getEmployee(Long employeeId) throws EmployeeObjExecptions{
	 String METHOD_NAME="getEmployee :";
	 Optional<Employee> optEmp=null;
	 try {
	 log.info(CLASS_NAME+METHOD_NAME+ "Entry  ::");
	log.info(CLASS_NAME+METHOD_NAME+" employeeId  ::"+employeeId);
		 	
		 	optEmp = employeeRepository.findById(employeeId);
		
	 }catch (Exception exp) {
	 
	 throw new EmployeeObjExecptions(exp.getMessage());
}
 log.info(CLASS_NAME+METHOD_NAME+" Exit");
	  return optEmp.get();
 }
 /**
* This method is to saveEmployee
* @param employee
*/  
 public void saveEmployee(Employee employee){
	 String METHOD_NAME="saveEmployee :";
	log.info(CLASS_NAME+METHOD_NAME+ "Entry");
	 employeeRepository.save(employee);
	log.info(CLASS_NAME+METHOD_NAME+ " Exit");
 }
 /**
* This method is to deleteEmployee
* @param employeeId
*/  
 public void deleteEmployee(Long employeeId){
	 String METHOD_NAME="deleteEmployee :";
	 log.info(CLASS_NAME+METHOD_NAME+" Entry");
	log.debug("deleteEmployee  employeeId"+employeeId);
  employeeRepository.deleteById(employeeId);
  log.info("deleteEmployee Exit");
 }
 /**
* This method is to updateEmployee details
* @param employee
*/   
 public void updateEmployee(Employee employee) {
	 String METHOD_NAME="updateEmployee :";
	log.info(CLASS_NAME+METHOD_NAME+" Entry");
  employeeRepository.save(employee);
 log.info(CLASS_NAME+METHOD_NAME+" Exit");
 }


}