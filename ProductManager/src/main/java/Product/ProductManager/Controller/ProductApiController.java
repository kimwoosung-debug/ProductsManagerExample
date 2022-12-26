package Product.ProductManager.Controller;

import Product.ProductManager.Domain.Products;
import Product.ProductManager.Service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductApiController {
    private final ProductService productService;


    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Products> listProducts() {
        List<Products> products = productService.findProduct();
        return products;
    }

    @PostMapping("/products")
    public Products createProducts(@RequestBody Products products) {
        Integer no = productService.register(products);
        return productService.findOne(no).get();
    }

    @PutMapping("/products/{no}")
    public Products updateProducts(@PathVariable Integer no, @RequestBody ProductsForm form) {
        Products products = productService.findOne(no).get();
        products.setName(products.getName());
        products.setPrice(products.getPrice());
        products.setStock(products.getStock());

        productService.update(products);
        return productService.findOne(no).get();
    }

    @DeleteMapping("/products/{no}")
    public void deleteProducts(@PathVariable Integer no) {
        productService.delete(no);
    }
}