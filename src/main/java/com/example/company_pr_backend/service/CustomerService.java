package com.example.company_pr_backend.service;

import com.example.company_pr_backend.dto.CustomerRequest;
import com.example.company_pr_backend.entity.Customer;
import com.example.company_pr_backend.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerRequest request) {
        Customer customer = new Customer(
                request.getFullName(),
                request.getEmail(),
                request.getPhone(),
                request.getMessage()
        );

        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateStatus(Long id, String status) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));

        customer.setStatus(status);

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}