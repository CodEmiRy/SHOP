package pl.codemiry.shop.calculate;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "calculate")
public class CalculateService {

    private int vat;
    private int discount;

    public void setVat(int vat) {
        this.vat = vat;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getVat() {
        return vat;
    }

    public int getDiscount() {
        return discount;
    }
}
