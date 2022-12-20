package Product.ProductManager;

import Product.ProductManager.Repository.JpaProductRepository;
import Product.ProductManager.Repository.MemoryProductRepository;
import Product.ProductManager.Repository.ProductRepository;
import Product.ProductManager.Service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository());
    }

    @Bean
    public ProductRepository productRepository() {
        return new JpaProductRepository(em);
    }
}

