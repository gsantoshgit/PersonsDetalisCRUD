package com.gs.demo.employee;

import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gs.demo.employee.entity.Employee;
import com.gs.demo.employee.services.EmployeeService;
@Component

public class MyCommondLineRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(SpringBootEmployeeRestServicesApplication.class);
	private static final String CLASS_NAME="SpringBootEmployeeRestServicesApplication :: ";
	private static String METHOD_NAME="";
	private static final String ENTRY="::  Entry";
	private static final String EXIT=":: Exit";
	@Autowired
	 EmployeeService employeeService ;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		METHOD_NAME="run";
		log.info(CLASS_NAME+METHOD_NAME+ENTRY);
		
		String fristName;
		String surname;
		long id=0;
		ArrayList<Employee> empleList;
		Scanner scanner = new Scanner(System.in);
		 int option=0; 
			/*
			 * System.out.
			 * println("Please select one option from below \n 1. Add Person \n 2. Edit Person \n 3. Delete person detail \n 4.Count of persons \n 5. List of all the persons "
			 * ); option = scanner.nextInt(); if(scanner.hasNextInt()) {
			 * id=scanner.nextInt(); }else {
			 * System.out.println("Please enter valid integer value  :"); option=0;
			 * 
			 * }
			 */
		while (option<6) {
		switch(option){
		case 0:
			System.out.println("Please select one option from below \n 1. Add Person \n 2. Edit Person \n 3. Delete person detail \n 4.Count of persons \n 5. List of all the persons ");
			///option=scanner.nextInt();
			 if(scanner.hasNextInt()) {
				 option=scanner.nextInt();
				 }else {
					 System.out.println("Please enter valid integer value  :");
					  System.out.println("-----------------------------------------------------");
					 scanner.next();
					 option=0;
						
				 }
			break;
		 case 1:
			 System.out.println("Please enter id :");
			  System.out.println("-----------------------------------------------------");
			 if(scanner.hasNextLong()) {
			 id=scanner.nextLong();
			 }else {
				 System.out.println("Please enter valid integer value  :");
				  System.out.println("-----------------------------------------------------");
				 scanner.next();
				option=1;
				 break;
			 }
			
			 System.out.println("Please enter the first name :");
			  System.out.println("-----------------------------------------------------");
				 fristName = scanner.next();
				
				System.out.println("Please enter Surname :");
				  System.out.println("-----------------------------------------------------");
				 surname = scanner.next();
				
				Employee emp=new Employee(id,fristName,surname);
				employeeService.saveEmployee(emp);
				 System.out.println("*********************************************************");
				System.out.println("Provided details are Saved successfully");
				  System.out.println("*********************************************************");
				
				  option=0;
			  break;
			  case 2:
				  System.out.println("*********************************************************");
				  System.out.println("Please enter id to edit the details:");
				  System.out.println("-----------------------------------------------------");
					 
					 if(scanner.hasNextLong()) {
						 id=scanner.nextLong();
						 }else {
							 System.out.println("*********************************************************");
							 System.out.println("Please enter valid integer value  :");
							  System.out.println("*********************************************************");
							 scanner.next();
							option=2;
							 break;
						 }
					 Employee empDet;
					 try {
					   empDet= employeeService.getEmployee(id);
					   System.out.println("*********************************************************");
					   System.out.println("Present Firstname "+empDet.getFirstName()+"\n ::Please enter updated first name :");
						 fristName = scanner.next();
						 System.out.println("*********************************************************");
						System.out.println("Present surname "+empDet.getSurName()+" \n :: Please enter updated Surname :");
						 surname = scanner.next();
						
						Employee emp1=new Employee(id,fristName,surname);
						
						employeeService.updateEmployee(emp1);
						 System.out.println("*********************************************************");
						System.out.println("Provided details are Updated successfully");
					 }catch (Exception e) {
						 System.out.println("*********************************************************");
						System.out.println("Provided ID is not available in the Database :"+e.getMessage());
						 option=2;
					}
					 
						  System.out.println("*********************************************************");
						//	System.out.println("Please select one option from below \n 1. Add Person \n 2. Edit Person \n 3. Delete person detail \n 4.Count of persons \n 5. List of all the persons ");
						//option=scanner.nextInt();
						  option=0;
			  break;
			  case 3:
				  System.out.println("*********************************************************");
				  System.out.println("Please enter id to delete the details:");
				  System.out.println("*********************************************************");
					 if(scanner.hasNextLong()) {
						 id=scanner.nextLong();
						 }else {
							 System.out.println("*********************************************************");
							 System.out.println("Please enter valid integer value  :");
							  System.out.println("*********************************************************");
							 scanner.next();
							option=3;
							 break;
						 }
					 try {
					 employeeService.deleteEmployee(id);
					 }catch(Exception ex) {
						 System.out.println("*********************************************************");
						 System.out.println("Record is not avaliable"+ex.getMessage());
						 option=3;
						 break;
					 }
					 System.out.println("*********************************************************");
					 System.out.println(" Record is deleted successfully ::");
					  System.out.println("*********************************************************");
						//System.out.println("Please select one option from below \n 1. Add Person \n 2. Edit Person \n 3. Delete person detail \n 4.Count of persons \n 5. List of all the persons ");
					  // option=scanner.nextInt();
					  option=0;
			  break;
		
			  case 4:
			    System.out.println("*********************************************************");
			    empleList=(ArrayList<Employee>) employeeService.retrieveEmployees();
			    System.out.println("Number of employees available are ::"+empleList.size());
			    
			    System.out.println("*********************************************************");
				//System.out.println("Please select one option from below \n 1. Add Person \n 2. Edit Person \n 3. Delete person detail \n 4.Count of persons \n 5. List of all the persons ");
				 //  option=scanner.nextInt();
			    option=0;
			
			  break;
			  case 5:
				  System.out.println("*********************************************************");
				    System.out.println("Below are the List Of Employee details ::");
				    System.out.println("*********************************************************");
				     empleList=(ArrayList<Employee>) employeeService.retrieveEmployees();
				    System.out.println("Number of employees available are ::"+empleList.size());
				    System.out.println("*********************************************************");
				    
				     for (Employee e : empleList) {
				    	 System.out.println("----------------------------------------------------");
				    	 System.out.println("[ ID  ]  ["+e.getId()+"] [First name  ::]  ["+ e.getFirstName() +"] [Last name ::] ["+e.getSurName()+"]");;
				    	 System.out.println("----------------------------------------------------");
					} 
				     System.out.println("*********************************************************");
				 //	System.out.println("Please select one option from below \n 1. Add Person \n 2. Edit Person \n 3. Delete person detail \n 4.Count of persons \n 5. List of all the persons ");
					//   option=scanner.nextInt();
				     option=0;
				
				  break;
			default:
				System.out.println("*********************************************************");
			System.out.println("Please select any of the options 1,2,3,4,5");
			System.out.println("*********************************************************");
			break;
     }
		}	 
		
		scanner.close();
		
		log.info(CLASS_NAME+METHOD_NAME+EXIT);
		
	}


}
