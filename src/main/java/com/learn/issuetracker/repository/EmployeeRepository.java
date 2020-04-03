package com.learn.issuetracker.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.learn.issuetracker.model.Employee;

/*
 * This class is used to read employees data from the file and store the data in a List.
 * Java 8 NIO should be used to read the file data in to streams 
*/
public class EmployeeRepository {
	
	/*
	 * This List will store the employee details read from the file
	 */
	private static List<Employee> employees;

	/*
	 * This static block should populate the 'employees' List by calling the static
	 * method 'initializeEmployeesFromFile' of this class. The path of the
	 * employees.csv file is "src --> data -> employees.csv"
	 */
	static {
		Path employeesfilePath = Paths.get("src", "data", "employees.csv");
		EmployeeRepository.initializeEmployeesFromFile(employeesfilePath);
	}

	/*
	 * This method is used to read from the file given in the input Path parameter.
	 * It should store all the records read from the file in to 'employees' member
	 * variable. This method should use 'parseEmployee' method of Utility class for
	 * converting the line read from the file in to Employee Object
	 */
	public static void initializeEmployeesFromFile(Path employeesfilePath) {
		try (Stream<String> bufferData = Files.newBufferedReader(employeesfilePath).lines()) {
			employees = bufferData.map(Utility::parseEmployee).collect(Collectors.toList());
		} catch (IOException e) {
		}
	}

	/*
	 * getEmployee method should search the 'employees' List based on the input
	 * employee Id, and return the employee found, in an Optional<Employee> object
	 */
	public static Optional<Employee> getEmployee(int empId) {
		return employees.stream().filter(f -> f.getEmplId()==empId)
				.findAny();
	}

	// Getter
	public static List<Employee> getEmployees() {
		return employees;
	}
}