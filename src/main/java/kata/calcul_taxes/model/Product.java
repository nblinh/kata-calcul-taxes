package kata.calcul_taxes.model;

import kata.calcul_taxes.service.Utils;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Product {
    private String name;
    private ProductCategoryEnum productCategory;
    private boolean isImported;
    private double price;
    private int quantity;

    public double getTaxApply() {
        float taxApply = switch (productCategory) {
            case BOOK, FOOD, MEDICINE -> 0;
            case OTHERS -> 10;
        };
        return isImported() ? taxApply + 5 : taxApply;
    }

    public double getTaxes() {
        return Utils.round05(price * getTaxApply() / 100) * quantity;
    }

    public double getPrices() {
        return price * quantity + getTaxes();
    }
}
