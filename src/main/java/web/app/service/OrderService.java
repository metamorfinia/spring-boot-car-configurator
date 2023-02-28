package web.app.service;
import org.springframework.stereotype.Service;
import web.app.model.Order;
import web.app.model.Product;
import web.app.model.ShoppingCart;
import web.app.repository.OrderRepository;
import web.app.repository.ProductRepository;

import java.util.Optional;
import java.util.List;
@Service
public class OrderService {
     private OrderRepository orderRepository;
     private ProductRepository productRepository;

     public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
          this.orderRepository = orderRepository;
          this.productRepository = productRepository;
     }
     public Order saveOrder(Order order) {
          return orderRepository.save(order);
     }

     public Order getOrderDetail(int orderId) {
          Optional<Order> order = this.orderRepository.findById(orderId);
          return order.isPresent() ? order.get() : null;
     }

     public float getCartAmount(List<ShoppingCart> shoppingCartList) {

          float totalCartAmount = 0f;
          float singleCartAmount = 0f;
          int availableQuantity = 0;

          for (ShoppingCart cart : shoppingCartList) {

               int productID = cart.getProductId();
               Optional<Product> product = productRepository.findById(productID);
               if (product.isPresent()) {
                    Product product1 = product.get();
                    if (product1.getAvailableQuantity() < cart.getQuantity()) {
                         singleCartAmount = product1.getPrice() * product1.getAvailableQuantity();
                         cart.setQuantity(product1.getAvailableQuantity());
                    }else {
                         singleCartAmount = cart.getQuantity() * product1.getPrice();
                         availableQuantity = product1.getAvailableQuantity() - cart.getQuantity();
                    }
                    totalCartAmount = totalCartAmount + singleCartAmount;
                    product1.setAvailableQuantity(availableQuantity);
                    availableQuantity = 0;
                    cart.setProductName(product1.getName());
                    cart.setAmount(singleCartAmount);
                    productRepository.save(product1);
               }
          }
          return totalCartAmount;
     }

}
