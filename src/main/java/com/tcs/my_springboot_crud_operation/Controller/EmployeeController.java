package com.tcs.my_springboot_crud_operation.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.my_springboot_crud_operation.Entity.Employee;
import com.tcs.my_springboot_crud_operation.Service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/employee")
@Tag(description = "this is employee controller class which can take all the request regarding employee get ,post,delete,put",
name = "MY-EMPLOYEE-CONTROLLER")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Operation(description = "Response ")
	@ApiResponses({
		@ApiResponse(responseCode = "200",description = "success"),
		@ApiResponse(responseCode = "400",description = "bad-request")
	})
	
    @GetMapping(value = "/getMyName")
	public String getMyName() {
		return "guess my name";
	}
    
    @PostMapping(value = "/RegisterMultipleEmployee")
    public List<Employee> registerMultipleEmployee(@RequestBody List<Employee> employees) {
    	
    	List<Employee> employee2 = employeeService.saveMultipleEmployeeService(employees);
    	
    	System.out.println(employee2);
    	return employee2;
    
    }
    
    @GetMapping("/getEmpById/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
		
		Optional<Employee> optional = employeeService.getEmployeeByIdService(id);
		
		if(optional.isPresent()) {
			
			Employee employee = optional.get();
			System.out.println("Employee Data: " + employee);

			
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("given id is not  present pls check once....");
    
    }
}
