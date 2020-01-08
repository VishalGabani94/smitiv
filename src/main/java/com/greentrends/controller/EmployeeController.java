package com.greentrends.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greentrends.model.Employee;
import com.greentrends.services.EmployeeServices;
import com.greentrends.utilities.Validator;

@RestController
@RequestMapping("green")
public class EmployeeController {

	@Autowired
	EmployeeServices employeeServices;

	/**
	 * 
	 * POST green/emp/create Host: http://localhost:8080/ 
	 * Accept: application/json,text/javascript
	 * 
	 * @param employee in JSON
	 * @return HttpStatus.OK if employee created successfully
	 */
	//1. Create an Employee with id and name
	@PostMapping("/emp/create")
	public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeServices
				.save(new Employee(employee.getEname())), HttpStatus.OK);
	}
	
	/**
	 * GET /green/get-all-emp Host: http://localhost:8080/
	 * 
	 * @return JSON of all employees list if found
	 */
	//2. Retrieve all the Employees
	@GetMapping("/get-all-emp")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		System.out.println("Get all Employee...");

		List<Employee> empDataList = new ArrayList<>();
		employeeServices.findAll().forEach(empDataList::add);

		return empDataList.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(empDataList, HttpStatus.OK);
	}

	/**
	 * Validations specific extension of
	 * {@link com.greentrends.utilities.Validator }
	 * 
	 * GET /green/emp/{id} Host: http://localhost:8080/
	 * 
	 * @param id
	 * @return JSON of employee if id exist
	 */
	//3. Retrieve the Employee based on id
	@GetMapping("emp/{id}")
	public ResponseEntity<Employee> findById(@PathVariable int id) {
		Employee empInfo = employeeServices.findById(id);

		return Validator.isEmpty(empInfo) ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(empInfo, HttpStatus.OK);
	}

}
