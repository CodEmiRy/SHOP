package pl.codemiry.shop.bill;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.codemiry.shop.calculate.CalculatePriceService;
import pl.codemiry.shop.calculate.CalculateService;

@Service
@Primary
@Profile("PRO")
public class ShopProService implements Bill {

    private final CalculateService calculateService;
    private final CalculatePriceService calculatePriceService;

    public ShopProService(CalculateService calculateService, CalculatePriceService calculatePriceService) {
        this.calculateService = calculateService;
        this.calculatePriceService = calculatePriceService;
    }

    @Override
    public String getInfo() {
        return "VAT: " + calculateService.getVat() + "% = "
                + String.format("%.2f", calculatePriceService.getVat()) + " ZŁ\nDISCOUNT: "
                + calculateService.getDiscount() + "% = "
                + String.format("%.2f", calculatePriceService.getDiscount()) + " ZŁ\nTO PAY: "
                + String.format("%.2f", calculatePriceService.getPriceWithVatAndDiscount()) + " ZŁ";
    }
}
