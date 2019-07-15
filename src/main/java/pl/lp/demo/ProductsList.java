package pl.lp.demo;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public class ProductsList {

    LinkedList<Product> products = new LinkedList<>();

    public ProductsList() {
        products.add(new Product("Kawa", 6.5, ProductCategory.ART_SPOŻYWCZE));
        products.add(new Product("Cukier", 4.2, ProductCategory.ART_SPOŻYWCZE));
        products.add(new Product("Mleko", 2.9, ProductCategory.ART_SPOŻYWCZE));
        products.add(new Product("Mikser", 200.0, ProductCategory.ART_GOSP_DOMOWEGO));
        products.add(new Product("Dzbanek", 15.0, ProductCategory.ART_GOSP_DOMOWEGO));
        products.add(new Product("Kubek", 6.9, ProductCategory.ART_GOSP_DOMOWEGO));
        products.add(new Product("Siekiera", 60.0, ProductCategory.INNE));
        products.add(new Product("Grabki", 30.0, ProductCategory.INNE));
        products.add(new Product("Wózek", 90.0, ProductCategory.INNE));

    }

    public LinkedList getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getPrice(int i) {
        return products.get(i).getPrice();
    }

}
