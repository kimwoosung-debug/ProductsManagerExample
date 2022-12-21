package Product.ProductManager.Repository;

import Product.ProductManager.Domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.Optional;
@Repository
public interface SpringDataJpaProductRepository extends JpaRepository<Products, Integer>, ProductRepository {

}
