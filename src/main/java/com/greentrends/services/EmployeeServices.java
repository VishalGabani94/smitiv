package com.greentrends.services;

import java.util.List;

import com.greentrends.model.Employee;

public interface EmployeeServices {

	List<Employee> findAll();

	Employee findById(int eId);

	Employee save(Employee employee);

}
