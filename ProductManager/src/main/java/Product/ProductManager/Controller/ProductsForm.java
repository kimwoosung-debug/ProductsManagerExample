package Product.ProductManager.Controller;

import Product.ProductManager.Domain.Products;
import Product.ProductManager.Service.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@Setter
public class ProductsForm {
    private String name;
    private int price;
    private int stock;
}
