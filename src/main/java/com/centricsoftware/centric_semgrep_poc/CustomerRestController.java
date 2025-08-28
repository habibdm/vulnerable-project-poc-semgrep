package com.centricsoftware.centric_semgrep_poc;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.inject.Inject;

@RestController
@RequestMapping("/api/v1/rest/customers")
public class CustomerRestController {

    @Inject
    private CustomerService customerService;

    @GetMapping
    public String greet(@RequestParam(value = "name", required = false, defaultValue = "John Doe") String name) {
	return "{\"greetings\": \"Hello! " + name + "\"}";
    }

    @GetMapping("/search")
    public List<Customer> findAllCustomersByLastName(@RequestParam(value = "lastName") String lastName) {
	return customerService.findByLastName(lastName);
    }

    @PostMapping
    public Customer addANewCustomer(@RequestBody Customer customer) {
	return customerService.save(customer);
    }

}
