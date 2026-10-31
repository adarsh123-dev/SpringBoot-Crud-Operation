package com.tcs.my_springboot_crud_operation.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tcs.my_springboot_crud_operation.Entity.Employee;
import com.tcs.my_springboot_crud_operation.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployeeService(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> saveMultipleEmployeeService(List<Employee> Employees){
		return employeeRepository.saveAll(Employees);
		
	}
	

	public Optional<Employee> getEmployeeByIdService(Integer id) {
		
		Optional<Employee> optional=employeeRepository.findById(id);
		
		return optional;
	}
	

}
