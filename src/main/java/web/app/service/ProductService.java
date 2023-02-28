package web.app.service;
import org.springframework.stereotype.Service;
import web.app.repository.ProductRepository;
import web.app.model.Product;

import java.util.List;
@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

}
