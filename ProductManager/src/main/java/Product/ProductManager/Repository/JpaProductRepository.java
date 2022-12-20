package Product.ProductManager.Repository;

import Product.ProductManager.Domain.Products;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaProductRepository implements ProductRepository {

    private final EntityManager em;

    public JpaProductRepository(EntityManager em) {
        this.em = em;
    }

    public Products save(Products products) {
        em.persist(products);
        return products;
    }

    public Optional<Products> findByNo(Integer no) {
        Products products = em.find(Products.class, no);
        return Optional.ofNullable(products);
    }

    public List<Products> findAll() {
        return em.createQuery("select m from Products m", Products.class)
                .getResultList();
    }

    public Optional<Products> findByName(String name) {
        List<Products> result = em.createQuery("select m from Products m where m.name= :name", Products.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}
