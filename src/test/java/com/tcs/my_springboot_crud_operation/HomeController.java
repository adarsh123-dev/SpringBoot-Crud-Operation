
package com.tcs.my_springboot_crud_operation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "My Spring Boot CRUD Operation is running!";
    }
}
