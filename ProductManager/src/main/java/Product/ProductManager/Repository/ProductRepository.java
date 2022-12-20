package Product.ProductManager.Repository;

import Product.ProductManager.Domain.Products;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Products save(Products products);

    Optional<Products> findByNo(Integer no);
    Optional<Products> findByName(String name);
    List<Products> findAll();
}
