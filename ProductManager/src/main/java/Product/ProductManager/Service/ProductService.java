package Product.ProductManager.Service;

import Product.ProductManager.Domain.Products;
import Product.ProductManager.Repository.MemoryProductRepository;
import Product.ProductManager.Repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Integer register(Products products) {

        validateDuplicateProduct(products);
        productRepository.save(products);
        return products.getNo();
    }

    private void validateDuplicateProduct(Products products) {
        productRepository.findByName(products.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 상품입니다.");
                });
    }

    public List<Products> findProduct() {
        return productRepository.findAll();
    }

    public Optional<Products> findOne(Integer productNo) {
        return productRepository.findByNo(productNo);
    }
}
