package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
