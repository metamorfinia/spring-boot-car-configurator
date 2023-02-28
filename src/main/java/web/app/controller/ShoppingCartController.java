package web.app.controller;
import java.util.List;
import java.util.logging.Logger;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.app.dto.OrderDTO;
import web.app.dto.ResponseOrderDTO;
import web.app.model.Customer;
import web.app.model.Order;
import web.app.model.Product;
import web.app.service.CustomerService;
import web.app.service.OrderService;
import web.app.service.ProductService;

//creating RestController
@RestController
@RequestMapping("/api")
public class ShoppingCartController {
    private OrderService orderService;
    private ProductService productService;
    private CustomerService customerService;

    public ShoppingCartController(OrderService orderService, ProductService productService, CustomerService customerService) {
        this.orderService = orderService;
        this.productService = productService;
        this.customerService = customerService;
    }

    //private Logger logger = (Logger) LoggerFactory.getLogger(ShoppingCartController.class);

    @GetMapping(value = "/allProducts")
    public ResponseEntity<List<Product>> getAllproducts() {
        List<Product> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }
   @GetMapping(value = "/getOrder/{orderId}")
   public ResponseEntity<Order> getOrderDetails ( @PathVariable int orderId){

            Order order = orderService.getOrderDetail(orderId);
            return ResponseEntity.ok(order);
        }

   @PostMapping("/placeOrder")
   public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO){
            //logger.info("Request payload" + orderDTO.toString());
            ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
            float amount = orderService.getCartAmount(orderDTO.getCartItems());

            Customer customer = new Customer(orderDTO.getCustomerName(), orderDTO.getCustomerEmail());
            Integer customerIdFromDb = customerService.isCustomerPresent(customer);
            if (customerIdFromDb != null) {
                customer.setId(customerIdFromDb);
                //logger.info("Customer already present in db with id: " + customerIdFromDb);
            } else {
                customer = customerService.saveCustomer(customer);
                //logger.info("Customer saved.. with id: " + customer.getId());
            }
            Order order = new Order(orderDTO.getOrderDescription(), customer, orderDTO.getCartItems());
            order = orderService.saveOrder(order);
            //logger.info("Order processed successfully..");

            responseOrderDTO.setAmount(amount);
            //responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
            responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
            responseOrderDTO.setOrderId(order.getId());
            responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());

            //logger.info("test push..");

            return ResponseEntity.ok(responseOrderDTO);
        }

    }

