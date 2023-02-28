package web.app.service;

import org.springframework.stereotype.Service;
import web.app.model.Customer;
import web.app.repository.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Integer isCustomerPresent(Customer customer) {
        Customer customer1 = customerRepository.getCustomerByEmailAndName(customer.getEmail(), customer.getName());
        return customer1!= null ? customer.getId() : null;
    }
}
