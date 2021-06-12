package com.gs.demo.employee;



import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.gs.demo.employee.entity.Employee;
import com.gs.demo.employee.exceptions.EmployeeObjExecptions;
import com.gs.demo.employee.serviceimpl.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeRepository {

	@Mock
	EmployeeServiceImpl empService;
	
	@Before
	 public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	 @Test
	    public void retrieveEmployeesTest()
	    {
	        List<Employee> list = new ArrayList<Employee>();
	        Employee empOne = new Employee(1l, "Santosh", "Gadepally");
	        Employee empTwo = new Employee(2l, "Rajesh", "Kunche");
	        Employee empThree = new Employee(3l, "Steve", "Arun");
	         
	        list.add(empOne);
	        list.add(empTwo);
	        list.add(empThree);
        when(empService.retrieveEmployees()).thenReturn(list);
	        List<Employee> empList = empService.retrieveEmployees();
	         
	        assertEquals(3, empList.size());
	        verify(empService, times(1)).retrieveEmployees();
	    }
	 
	 @Test
	    public void saveEmployeeTest()
	    {
	        Employee emp = new Employee(1l,"Santosh","Gadepally");
	         
	        empService.saveEmployee(emp);
	         
	        verify(empService, times(1)).saveEmployee(emp);
	    }
	 
	 @Test
	    public void deleteEmployee()
	    {
	        empService.deleteEmployee(1l);
	         
	        verify(empService, times(1)).deleteEmployee(1l);
	    }
	 
	 @Test
	    public void getEmployeeTest() throws EmployeeObjExecptions
	    {
		 when(empService.getEmployee(1l)).thenReturn(new Employee(1l,"Santosh","Gadepally"));
	        Employee emp = empService.getEmployee(1l);
	        assertEquals("Santosh", emp.getFirstName());
	        assertEquals("Gadepally", emp.getSurName());
	       
	        
	    }
}
