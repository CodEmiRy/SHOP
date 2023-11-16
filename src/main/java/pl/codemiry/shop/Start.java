package pl.codemiry.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.codemiry.shop.bill.Bill;
import pl.codemiry.shop.product.ProductsToBuyService;

@Component
public class Start {

    private final Bill bill;
    private final ProductsToBuyService productsToBuyService;

    @Autowired
    public Start(Bill bill, ProductsToBuyService productsToBuyService) {
        this.productsToBuyService = productsToBuyService;
        this.bill = bill;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showRandomList() {
        System.out.println("\n\nSUPER SHOP!!!!\nBILL: ");
        System.out.println(productsToBuyService.toString());
        System.out.println("SUM: " + String.format("%.2f", productsToBuyService.getSum()) + " ZŁ");
        System.out.println(bill.getInfo());
    }
}
