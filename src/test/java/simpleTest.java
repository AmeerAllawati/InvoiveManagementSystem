import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import invoiceManager.Product;

/**
 * 
 */

/**
 * @author LAP-1
 *
 */
class simpleTest {

    @Test
    void test() {
        Product newProduct = new Product(1, "first product", 2.0, 10);
        newProduct.setUnitPrice(9.0);
        assertEquals(newProduct.getUnitPrice(), 9.0);;
    }

}
