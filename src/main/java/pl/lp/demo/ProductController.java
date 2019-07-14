package pl.lp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;

@Controller
public class ProductController {
    ProductsList productsList;

    public ProductController(ProductsList productsList) {
        this.productsList = productsList;
    }

    @ResponseBody
    @RequestMapping("/products")
    public String getAllProducts() {
        String products = "";
        LinkedList list = productsList.getProducts();
        for (int i = 0; i < list.size(); i++) {
            products += list.get(i).toString() + "<br/>";
        }
        return products;
    }

    @RequestMapping("/add")
    //   @ResponseBody
    public String addProduct(@RequestParam String name, @RequestParam Double price, @RequestParam ProductCategory productCategory) {
        Product product = new Product(name, price, productCategory);
        productsList.addProduct(product);
        //return "Dodano produkt: " + name + " " + price + " " + productCategory;
        return "redirect:/products";
    }

    @RequestMapping("/lista")
    @ResponseBody
    public String filter(@RequestParam ProductCategory productCategory) {
        String products = "";
        String productCat = String.valueOf(productCategory);
        LinkedList list = productsList.getProducts();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().contains(productCat)) {
                products += list.get(i).toString() + "<br/>";
            }
        }
        return products;
    }
}//localhost:8080/lista?productCategory=ART_SPOŻYWCZE