package pl.codemiry.shop.bill;

import org.springframework.stereotype.Service;

@Service
public class ShopStartService implements Bill {

    @Override
    public String getInfo() {
        return "HAVE A NICE DAY!";
    }
}
