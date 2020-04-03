package com.learn.issuetracker.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.learn.issuetracker.model.Employee;
import com.learn.issuetracker.model.Issue;

/*
 * This class has methods for parsing the String read from the files in to corresponding Model Objects
*/
public class Utility {
	
	private Utility() {
		//Private Constructor to prevent object creation
	}

	/*
	 * parseEmployee takes a string with employee details as input parameter and parses it in to an Employee Object 
	*/
	public static Employee parseEmployee(String employeeDetail) {
		if((employeeDetail!=null) && (!employeeDetail.isBlank())) {
			String[] input = employeeDetail.split(",");
			return new Employee(Integer.parseInt(input[0]), input[1], input[2]);
		}
		return null;
		
	}

	/*
	 * parseIssue takes a string with issue details and parses it in to an Issue Object. The employee id in the 
	 * Issue details is used to search for an an Employee, using EmployeeRepository class. If the employee is found
	 * then it is set in the Issue object. If Employee is not found, employee is set as null in Issue Object  
	*/

	public static Issue parseIssue(String issueDetail) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if((issueDetail!=null) && (!issueDetail.isBlank())) {
			String[] input = issueDetail.split(",");
			Optional<Employee> employee=EmployeeRepository.getEmployee(Integer.parseInt(input[6]));
			Employee emp;
			if(employee.isPresent()){
				emp = employee.get();
			}
			else {
				emp = null;
			}
			return new Issue(input[0], input[1],LocalDate.parse(input[2], format), LocalDate.parse(input[3], format), input[4], input[5], emp);
		}
		return null;
	}
	
	
}
