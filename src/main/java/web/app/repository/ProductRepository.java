package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
