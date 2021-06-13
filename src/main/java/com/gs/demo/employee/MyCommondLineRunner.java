/**
 *   Copyright 2021 by G Santosh Chary All Rights Reserved.
 *
 *        @filename         : MyCommondLineRunner.java
 *        @version          : 1.0.0
 *        @date             : June 12, 2021
 *        @description		: This Controller class is used to do the get,put,post request mappings
 *
 *        @author <a href="mailto:santoshchary.gadepally@gmail.com">Santosh Chary Gadepally/a>
 *
 * History of modifications:
 * Author                            Date                Description of modifications
 * ------------                  ------------         ------------------------------
 * Santosh Chary Gadepally   		June 12, 2021            Created.
 **/
package com.gs.demo.employee;

import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gs.demo.employee.config.IConstantMessages;
import com.gs.demo.employee.entity.Employee;
import com.gs.demo.employee.exceptions.EmployeeObjExecptions;
import com.gs.demo.employee.services.EmployeeService;

@Component

public class MyCommondLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootEmployeeRestServicesApplication.class);
	private static final String CLASS_NAME = "SpringBootEmployeeRestServicesApplication :: ";
	private static String METHOD_NAME = "";
	private static final String ENTRY = "::  Entry";
	private static final String EXIT = ":: Exit";
	@Autowired
	EmployeeService employeeService;
	@Override
	public void run(String... args) throws Exception {
		METHOD_NAME = "run";
		log.info(CLASS_NAME + METHOD_NAME + ENTRY);

		String fristName;
		String surname;
		long id = 0;
		ArrayList<Employee> empleList;
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		while (option < 6) {
			switch (option) {
			case 0:
				log.info(IConstantMessages.PLEASE_SELECT_OPTION);
				
				
				if (scanner.hasNextInt()) {
					option = scanner.nextInt();
					if(option>6) {
					option = 0;	
					}
				} else {
					log.info(IConstantMessages.PLEASE_SELECT_INT_VALUE);
					scanner.next();
					option = 0;
				}
				break;
			case 1:
				log.info(IConstantMessages.ENTER_ID);
				if (scanner.hasNextLong()) {
					id = scanner.nextLong();
				} else {
					log.info(IConstantMessages.PLEASE_SELECT_INT_VALUE);
					scanner.next();
					option = 1;
					break;
				}
				log.info(IConstantMessages.PLEASE_ENTER_FIRST_NAME);
				fristName = scanner.next();
				log.info(IConstantMessages.PLEASE_ENTER_SUR_NAME);
				surname = scanner.next();
				Employee emp = new Employee(id, fristName, surname);
				try {
					employeeService.saveEmployee(emp);
				}
				catch (EmployeeObjExecptions empExp) {
					log.error(empExp.getMessage());
				}
				catch (Exception e) {
					log.error(e.getMessage());
				}
				log.info(IConstantMessages.LINE);
				log.info(IConstantMessages.DATA_SAVED_MSG);
				option = 0;
				break;

			case 2:
				log.info(IConstantMessages.LINE);
				log.info(IConstantMessages.ID_TO_EDIT_MSG);
				if (scanner.hasNextLong()) {
					id = scanner.nextLong();
				} else {
					log.info(IConstantMessages.LINE);
					log.info(IConstantMessages.PLEASE_SELECT_INT_VALUE);
					scanner.next();
					option = 2;
					break;
				}
				Employee empDet;
				try {
					empDet = employeeService.getEmployee(id);
					log.info(IConstantMessages.LINE);
					log.info(IConstantMessages.PRESENT_FNAME_MSG + empDet.getFirstName() + IConstantMessages.UPDATED_FNAME_MSG);
					fristName = scanner.next();
					log.info(IConstantMessages.LINE);
					log.info(IConstantMessages.PRESENT_SURNAME_MSG + empDet.getSurName() +IConstantMessages.UPDATED_SURNAME_MSG);
					surname = scanner.next();
					Employee emp1 = new Employee(id, fristName, surname);
					employeeService.updateEmployee(emp1);
					log.info(IConstantMessages.LINE);
					log.info(IConstantMessages.DATA_SAVED_MSG);
				}
				catch (EmployeeObjExecptions empExp) {
					log.error(empExp.getMessage());
				}
				catch (Exception e) {
					log.info(IConstantMessages.LINE);
					log.info(IConstantMessages.ID_NOT_AVAILABLE_MSG + e.getMessage());
					option = 2;
				}
				log.info(IConstantMessages.LINE);
				option = 0;
				break;
			case 3:
				log.info(IConstantMessages.LINE);
				log.info(IConstantMessages.PLEASE_ENTER_ID_TO_DEL);
				log.info(IConstantMessages.LINE);
				if (scanner.hasNextLong()) {
					id = scanner.nextLong();
				} else {
					log.info(IConstantMessages.LINE);
					log.info(IConstantMessages.PLEASE_SELECT_INT_VALUE);
					log.info(IConstantMessages.LINE);
					scanner.next();
					option = 3;
					break;
				}
				try {
					employeeService.deleteEmployee(id);
				} 
				catch (EmployeeObjExecptions empExp) {
					log.error(empExp.getMessage());
					option = 3;
					break;
				}
				catch (Exception ex) {
					log.info(IConstantMessages.LINE);
					log.info(IConstantMessages.REC_NOT_AVAILABLE_MSG+ ex.getMessage());
					option = 3;
					break;
				}
				log.info(IConstantMessages.LINE);
				log.info(IConstantMessages.RECORD_DELETED_MSG);
				log.info(IConstantMessages.LINE);
				option = 0;
				break;
			case 4:
				try {
				log.info(IConstantMessages.LINE);
				empleList = (ArrayList<Employee>) employeeService.retrieveEmployees();
				log.info(IConstantMessages.NO_OF_PERSONS_AVAILABLE + empleList.size());
			} 
			catch (EmployeeObjExecptions empExp) {
				log.error(empExp.getMessage());
				option = 0;
				break;
			}
			catch (Exception ex) {
				log.info(IConstantMessages.LINE);
				log.info(IConstantMessages.REC_NOT_AVAILABLE_MSG+ ex.getMessage());
				option = 0;
				break;
			}

				log.info(IConstantMessages.LINE);
				option = 0;
				break;
			case 5:
				log.info(IConstantMessages.LINE);
				log.info(IConstantMessages.LIST_OF_PERSONS_MSG);
				log.info(IConstantMessages.LINE);
				empleList = (ArrayList<Employee>) employeeService.retrieveEmployees();
				log.info(IConstantMessages.LINE);

				for (Employee e : empleList) {
					log.info(IConstantMessages.LINE);
					log.info(IConstantMessages.ID + e.getId() + IConstantMessages.FIRSTNAME+ e.getFirstName()
					+ IConstantMessages.SURNAME + e.getSurName() + "]");
					;
					log.info(IConstantMessages.LINE);
				}
				log.info(IConstantMessages.LINE);
				option = 0;

				break;
			default:
				log.info(IConstantMessages.LINE);
				log.info(IConstantMessages.PLEASE_SELECT_OPTION);
				log.info(IConstantMessages.LINE);
				break;
			}
		}
		scanner.close();
		log.info(CLASS_NAME + METHOD_NAME + EXIT);

	}

}
