package pl.codemiry.shop.calculate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codemiry.shop.product.ProductsToBuyService;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatePriceService {

    private final CalculateService calculateService;
    private final ProductsToBuyService productsToBuyService;

    @Autowired
    public CalculatePriceService(CalculateService calculateService, ProductsToBuyService productsToBuyService) {
        this.productsToBuyService = productsToBuyService;
        this.calculateService = calculateService;
    }

    public double getPriceWithVat() {
        return round(productsToBuyService.getSum() * (calculateService.getVat() + 100) / 100);
    }

    public double getVat() {
        return round(productsToBuyService.getSum() * (calculateService.getVat()) / 100);
    }

    public double getDiscount() {
        return round(getPriceWithVat() * (calculateService.getDiscount()) / 100);
    }

    public double getPriceWithVatAndDiscount() {
        return round(getPriceWithVat() * (100 - calculateService.getDiscount()) / 100);
    }

    public static double round(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
