package kata.calcul_taxes.service;

import kata.calcul_taxes.model.Product;
import kata.calcul_taxes.model.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static kata.calcul_taxes.model.ProductCategoryEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculTaxesServiceTests {
    @InjectMocks
    CalculTaxesService calculTaxesService;

    @Test
    public void calculShoppingCartTest1() {
        //given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1);
        shoppingCart.addToCart(Product.builder().name("livre").productCategory(BOOK).price(12.49).quantity(1).isImported(false).build());
        shoppingCart.addToCart(Product.builder().name("CD musical").productCategory(OTHERS).price(14.99).quantity(1).isImported(false).build());
        shoppingCart.addToCart(Product.builder().name("barre de chocolat").productCategory(FOOD).price(0.85).quantity(1).isImported(false).build());

        //when
        shoppingCart = calculTaxesService.calculShoppingCart(shoppingCart);

        //then
        shoppingCart.printInput();
        shoppingCart.printOutput();
        assertEquals(1.50, shoppingCart.getTaxes(), 0.001);
        assertEquals(29.83, shoppingCart.getTotal(), 0.001);
    }

    @Test
    public void calculShoppingCartTest2() {
        //given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(2);
        shoppingCart.addToCart(Product.builder().name("boîte de chocolats importée").productCategory(FOOD).price(10.00).quantity(1).isImported(true).build());
        shoppingCart.addToCart(Product.builder().name("flacon de parfum importé").productCategory(OTHERS).price(47.50).quantity(1).isImported(true).build());

        //when
        shoppingCart = calculTaxesService.calculShoppingCart(shoppingCart);

        //then
        shoppingCart.printInput();
        shoppingCart.printOutput();
        assertEquals(7.65, shoppingCart.getTaxes(), 0.001);
        assertEquals(65.15, shoppingCart.getTotal(), 0.001);
    }

    @Test
    public void calculShoppingCartTest3() {
        //given
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(3);
        shoppingCart.addToCart(Product.builder().name("flacon de parfum importé").productCategory(OTHERS).price(27.99).quantity(1).isImported(true).build());
        shoppingCart.addToCart(Product.builder().name("flacon de parfum").productCategory(OTHERS).price(18.99).quantity(1).isImported(false).build());
        shoppingCart.addToCart(Product.builder().name("boîte de pilules contre la migraine").productCategory(MEDICINE).price(9.75).quantity(1).isImported(false).build());
        shoppingCart.addToCart(Product.builder().name("boîte de chocolats importés").productCategory(FOOD).price(11.25).quantity(1).isImported(true).build());

        //when
        shoppingCart = calculTaxesService.calculShoppingCart(shoppingCart);

        //then
        shoppingCart.printInput();
        shoppingCart.printOutput();
        assertEquals(6.70, shoppingCart.getTaxes(), 0.001);
        assertEquals(74.68, shoppingCart.getTotal(), 0.001);
    }
}
