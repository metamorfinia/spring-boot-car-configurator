package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer getCustomerByEmailAndName(String email, String name);
}
