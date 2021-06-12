package com.gs.demo.employee.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Santosh Chary Gadepally
 *
 */
@Entity
@Table
public class Employee {
  
 public Employee(Long id, String firstName, String surName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surName = surName;
	}

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

@Id
 private Long id;
 
 public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getSurName() {
	return surName;
}

public void setSurName(String surName) {
	this.surName = surName;
}

private String firstName;

 private String surName;
  

 
 public Long getId() {
  return id;
 }
 
 public void setId(Long id) {
  this.id = id;
 }
 
}