package kata.calcul_taxes.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTests {

    @ParameterizedTest
    @CsvSource({"0.99,1.00", "1.00,1.00", "1.01,1.05", "1.02,1.05"})
    public void roundTest(double input, double expected) {
        double roundValue = Utils.round05(input);
        assertEquals(expected, roundValue);
    }
}
