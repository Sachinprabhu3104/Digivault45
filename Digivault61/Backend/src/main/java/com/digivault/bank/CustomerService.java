package com.digivault.bank;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    } 

    /**
     * Get all the products.
     *
     * @return the list of entities
     */
    public List<Customersupport> fetchCustomersupport() {
        return customerRepository.findAll();
    }

    /**
     * Save a new customer support request.
     *
     * @param support the support request to save
     */
    public void saveSupportRequest(Customersupport support) {
        customerRepository.save(support);
    }
}
