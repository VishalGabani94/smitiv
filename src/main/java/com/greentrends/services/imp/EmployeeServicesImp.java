package com.greentrends.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greentrends.model.Employee;
import com.greentrends.repository.EmployeeRepository;
import com.greentrends.services.EmployeeServices;

@Service
public class EmployeeServicesImp implements EmployeeServices{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int eid) {
		return employeeRepository.findById(eid);
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

}
