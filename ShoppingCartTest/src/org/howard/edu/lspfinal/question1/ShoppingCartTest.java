package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    
    private ShoppingCart cart;
    
    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }
    
    @Test
    @DisplayName("Test for adding valid item")
    public void testAddValidItem() {
        cart.addItem("Apple", 1.99);
        cart.addItem("Orange", 0.99);
        assertEquals(2.98, cart.getTotalCost(), 0.001);
    }
    
    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    public void testAddItemWithZeroPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Free Item", 0);
        });
    }
    
    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    public void testAddItemWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Negative Item", -5.99);
        });
    }
    
    @Test
    @DisplayName("Test for applying \"SAVE10\"")
    public void testApplySave10Discount() {
        cart.addItem("Laptop", 1000.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
        assertEquals(900.0, cart.getTotalCost(), 0.001);
    }
    
    @Test
    @DisplayName("Test for applying \"SAVE20\"")
    public void testApplySave20Discount() {
        cart.addItem("Laptop", 1000.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
        assertEquals(800.0, cart.getTotalCost(), 0.001);
    }
    
    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    public void testApplyInvalidDiscountCode() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("");
        });
    }
    
    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        cart.addItem("Phone", 899.99);
        cart.addItem("Case", 29.99);
        cart.addItem("Charger", 19.99);
        assertEquals(949.97, cart.getTotalCost(), 0.01);
    }
    
    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        cart.addItem("Phone", 899.99);
        cart.addItem("Case", 29.99);
        cart.addItem("Charger", 19.99);
        cart.applyDiscountCode("SAVE20");
        assertEquals(759.976, cart.getTotalCost(), 0.01);
    }
    
    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostWithEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), 0.001);
        
        // Apply discount to empty cart
        cart.applyDiscountCode("SAVE10");
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }
    
    @Test
    @DisplayName("Test removing existing items")
    public void testRemoveExistingItem() {
        cart.addItem("Apple", 1.99);
        cart.addItem("Orange", 0.99);
        cart.removeItem("Apple");
        assertEquals(0.99, cart.getTotalCost(), 0.001);
    }
    
    @Test
    @DisplayName("Test removing non-existent items")
    public void testRemoveNonExistentItem() {
        cart.addItem("Apple", 1.99);
        assertThrows(IllegalArgumentException.class, () -> {
            cart.removeItem("Banana");
        });
    }
    
    @Test
    @DisplayName("Test cart size updates correctly")
    public void testCartSizeUpdates() {
        assertEquals(0, cart.getSize());
        cart.addItem("Apple", 1.99);
        assertEquals(1, cart.getSize());
        cart.addItem("Orange", 0.99);
        assertEquals(2, cart.getSize());
        cart.removeItem("Apple");
        assertEquals(1, cart.getSize());
    }
}

// https://docs.oracle.com/javase/8/docs/api/