package com.tcs.my_springboot_crud_operation.Entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data  
@Entity
@JsonPropertyOrder({"id","name","email","phone","salary"})
@Schema(description = "this is an entity class which is connected with db table so becareful while passing data")
public class Employee {
	  @Id
	  @Schema(description = "please dont pass negative id")
	private Integer id;
	private String name;
	private String email;


}
