package pl.codemiry.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class ProductsToBuyService {
    private final AllProductsService productService;
    private List<Product> fiveRandomProducts;

    @Autowired
    public ProductsToBuyService(AllProductsService productService, List<Product> fiveRandomProducts) {
        this.productService = productService;
        this.fiveRandomProducts = fiveRandomProducts;
        getFiveRandomProducts();
    }

    public void getFiveRandomProducts() {
        fiveRandomProducts = new ArrayList<>();
        Collections.shuffle(productService.getProductList());
        IntStream.range(0, 5).forEach(i -> fiveRandomProducts.add(productService.getProductList().get(i)));
    }

    @Override
    public String toString() {
        StringBuilder productsLists = new StringBuilder();
        for (Product product : fiveRandomProducts) {
            productsLists.append("Product: ").append(product.getName())
                    .append(" Price: ").append(product.getPrice()).append(",00 zł.\n");
        }
        return productsLists.toString();
    }

    public double getSum() {
        return fiveRandomProducts.stream().mapToInt(Product::getPrice).sum();
    }
}
