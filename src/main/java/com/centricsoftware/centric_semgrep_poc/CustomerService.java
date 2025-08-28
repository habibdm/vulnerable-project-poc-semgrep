package com.centricsoftware.centric_semgrep_poc;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.inject.Inject;

@Service
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public List<Customer> findByLastName(String lastName) {
	return customerRepository.findByLastName(lastName);
    }

    public Customer save(Customer customer) {
	return customerRepository.saveAndFlush(customer);
    }

}
