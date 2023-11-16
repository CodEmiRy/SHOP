package pl.codemiry.shop.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AllProductsService {

    private final List<Product> productList;

    public AllProductsService() {
        productList = new ArrayList<>();
        productList.add(new Product("POTATO", randomPrice()));
        productList.add(new Product("TOMATO", randomPrice()));
        productList.add(new Product("BANANA", randomPrice()));
        productList.add(new Product("APPLE", randomPrice()));
        productList.add(new Product("CARROT", randomPrice()));
        productList.add(new Product("ONION", randomPrice()));
        productList.add(new Product("LEMON", randomPrice()));
        productList.add(new Product("PEAR", randomPrice()));
        productList.add(new Product("PUMPKIN", randomPrice()));
        productList.add(new Product("PEPPER", randomPrice()));
    }

    private int randomPrice() {
        Random rand = new Random();
        return rand.nextInt(251) + 50;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
