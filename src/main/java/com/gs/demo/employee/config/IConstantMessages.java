package com.gs.demo.employee.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public interface IConstantMessages {
	
	public static final String PLEASE_SELECT_OPTION="Please select one option from below \n 1. Add Person \n 2. Edit Person \n 3. Delete person detail \n 4. Count of persons \n 5. List of all the persons";
	public static final String PLEASE_SELECT_INT_VALUE="Please enter valid integer value  :";
	public static final String LINE="-----------------------------------------------------";
	public static final String ENTER_ID="Please enter id :";
	public static final String PLEASE_ENTER_FIRST_NAME="Please enter the first name :";
	public static final String PLEASE_ENTER_SUR_NAME="Please enter the Surname :";
	public static final String PLEASE_ENTER_ID_TO_DEL="Please enter id to delete the details:";
	public static final String NO_OF_PERSONS_AVAILABLE="Number of Persons available are ::";
	public static final String ID="[ ID  ]  [";
	public static final String FIRSTNAME="] [First name  ::]  [";
	public static final String SURNAME="] [Last name ::] [";
	public static final String LIST_OF_PERSONS_MSG="Below are the List Of Employee details ::";
	public static final String DATA_SAVED_MSG="Data Saved successfully";
	public static final String ID_TO_EDIT_MSG="Please enter id to edit the details:";
	public static final String PRESENT_FNAME_MSG="Present Firstname ";
	public static final String PRESENT_SURNAME_MSG="Present Firstname ";
	public static final String ID_NOT_AVAILABLE_MSG="Provided ID is not available in the Database :";
	public static final String UPDATED_FNAME_MSG="\n ::Please enter updated first name :";
	public static final String UPDATED_SURNAME_MSG= " \n :: Please enter updated Surname :";
	public static final String RECORD_DELETED_MSG=" Record is deleted successfully ::";
	public static final String REC_NOT_AVAILABLE_MSG="Record is not avaliable"; 

}
