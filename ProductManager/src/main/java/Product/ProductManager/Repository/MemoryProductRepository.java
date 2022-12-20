package Product.ProductManager.Repository;

import Product.ProductManager.Domain.Products;

import java.util.*;

public class MemoryProductRepository implements ProductRepository {

    private static Map<Integer, Products> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public Products save(Products products) {
        products.setNo(++sequence);
        store.put(products.getNo(), products);
        return products;
    }

    @Override
    public Optional<Products> findByNo(Integer no) {
        return Optional.ofNullable(store.get(no));
    }

    @Override
    public Optional<Products> findByName(String name) {
        return store.values().stream()
                .filter(products -> products.getName().equals(name))
                .findAny();

    }

    @Override
    public List<Products> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
