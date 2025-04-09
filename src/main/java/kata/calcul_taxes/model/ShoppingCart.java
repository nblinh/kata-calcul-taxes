package kata.calcul_taxes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

import static kata.calcul_taxes.service.Utils.round;

@Setter
@Getter
@NoArgsConstructor
public class ShoppingCart {
    private int id;
    private List<Product> products = new ArrayList<>();
    private double taxes;
    private double total;

    public void addToCart(Product product) {
        products.add(product);
    }

    public void printInput() {
        System.out.println("INPUT " + id);
        products.forEach(product -> System.out.println(product.getQuantity() + " " + product.getName() + " à " + round(product.getPrice())));
    }

    public void printOutput() {
        System.out.println("OUTPUT " + id);
        products.forEach(product -> System.out.print(product.getQuantity() + " " + product.getName() + ": " + round(product.getPrices()) + " "));
        System.out.println("Montant des taxes: " + round(taxes) + " Total: " + round(total));
    }
}
