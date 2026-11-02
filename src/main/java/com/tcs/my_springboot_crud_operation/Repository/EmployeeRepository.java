package com.tcs.my_springboot_crud_operation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.my_springboot_crud_operation.Entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee> findByEmail(String email);
	
	boolean existsBySalary(Double salary);
	
	@Transactional
	int deleteBySalary(Double salary);
	
	
	
	
}
