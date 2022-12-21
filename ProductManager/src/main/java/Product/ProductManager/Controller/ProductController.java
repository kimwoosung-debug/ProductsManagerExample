package Product.ProductManager.Controller;

import Product.ProductManager.Domain.Products;
import Product.ProductManager.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products/new")
    public String createForm() {
        return "products/createProductsForm";
    }

    @PostMapping(value = "/products/new")
    public String create(ProductsForm form) {

        Products products = new Products();
        products.setName(form.getName());
        products.setPrice(form.getPrice());
        products.setStock(form.getStock());

        productService.register(products);

        return "redirect:/";
    }

    @GetMapping(value = "/products")
    public String list(Model model) {
        List<Products> products = productService.findProduct();
        model.addAttribute("products", products);
        return "products/List";
    }

    @GetMapping(value = "/products/{no}/edit")
    public String updateForm(@PathVariable("no") Integer no, @ModelAttribute("product") Products products) {
        return "products/productUpdateForm";
    }

    @PostMapping(value = "/products/{no}/edit")
    public String updateProduct(@PathVariable("no") Integer no, @ModelAttribute("product") Products products) {

        products.setNo(no);
        products.setName(products.getName());
        products.setPrice(products.getPrice());
        products.setStock(products.getStock());
        productService.update(products);

        return "redirect:/products";
    }


    @GetMapping("/products/{no}/delete")
    public String deleteProduct(@PathVariable("no") Integer no) {
        productService.delete(no);

        return "redirect:/products";
    }
}
