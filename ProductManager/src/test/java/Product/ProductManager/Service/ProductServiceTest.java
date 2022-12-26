package Product.ProductManager.Service;

import Product.ProductManager.Domain.Products;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    ProductService productService;
    MemoryProductRepository productRepository;

    @BeforeEach
    public void beforeEach() {
        productRepository = new MemoryProductRepository();
        productService = new ProductService(productRepository);
    }

    @AfterEach
    public void afterEach() {
        productRepository.clearStore();
    }

    @Test
    public void 상품등록() throws Exception {
        Products products = new Products();
        products.setName("삼다수");

        Integer saveNo = productService.register(products);

        Products findproduct = productRepository.findByNo(saveNo).get();
        assertEquals(products.getName(), findproduct.getName());
    }

    @Test
    public void 중복_상품_예외() throws Exception {

        Products products1 = new Products();
        products1.setName("코카콜라");

        Products products2 = new Products();
        products2.setName("코카콜라");

        productService.register(products1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> productService.register(products2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 상품입니다.");

    }

}