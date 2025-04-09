package kata.calcul_taxes.service;

import kata.calcul_taxes.model.Product;
import kata.calcul_taxes.model.ShoppingCart;
import org.springframework.stereotype.Service;

@Service
public class CalculTaxesService {

    public ShoppingCart calculShoppingCart(ShoppingCart shoppingCart) {
        shoppingCart.setTaxes(shoppingCart.getProducts().stream()
                .map(Product::getTaxes).reduce(0.0, Double::sum));
        shoppingCart.setTotal(shoppingCart.getProducts().stream()
                .map(Product::getPrices).reduce(0.0, Double::sum));
        return shoppingCart;
    }

}
