package Product.ProductManager.Controller;

import Product.ProductManager.Domain.Products;
import Product.ProductManager.Service.ProductService;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.PostMapping;

public class ProductsForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @PostMapping(value = "/products/new")
//    public String create(ProductsForm form) {
//
//        Products products = new Products();
//        products.setName(form.getName());
//
//        ProductService.register(products);
//
//        return "redirect:/";
//    }
}
