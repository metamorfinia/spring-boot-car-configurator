package web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.app.model.ShoppingCart;
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
}
