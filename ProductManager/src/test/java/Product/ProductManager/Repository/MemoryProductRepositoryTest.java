package Product.ProductManager.Repository;

import Product.ProductManager.Domain.Products;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class MemoryProductRepositoryTest {

    MemoryProductRepository repository = new MemoryProductRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Products products = new Products();
        products.setName("삼다수");

        //when
        repository.save(products);

        //then
        Products result = repository.findByNo(products.getNo()).get();
        assertThat(result).isEqualTo(products);
    }
    @Test
    public void findByName() {
        Products products1 = new Products();
        products1.setName("에비앙");
        repository.save(products1);

        Products products2 = new Products();
        products2.setName("코카콜라");
        repository.save(products2);

        Products result = repository.findByName("에비앙").get();
        assertThat(result).isEqualTo(products1);
    }

    @Test
    public void findAll() {
        Products products1 = new Products();
        products1.setName("에비앙");
        repository.save(products1);

        Products products2 = new Products();
        products2.setName("코카콜라");
        repository.save(products2);

        List<Products> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }




}