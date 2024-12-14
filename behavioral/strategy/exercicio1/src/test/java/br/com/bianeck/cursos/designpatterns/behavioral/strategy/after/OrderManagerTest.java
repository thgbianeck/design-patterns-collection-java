package br.com.bianeck.cursos.designpatterns.behavioral.strategy.after;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderManagerTest {
    private OrderManager orderManager;
    private Order order;

    @BeforeEach
    void setUp() {
        orderManager = new OrderManager();
        order = new Order();
        order.setItems(Arrays.asList(
            new OrderItem("Product 1", 50.0, 2),
            new OrderItem("Product 2", 30.0, 1)
        ));
        order.setCustomerType(CustomerType.REGULAR);
        Address address = new Address();
        address.setCountry("USA");
        order.setShippingAddress(address);
        order.setShippingMethod(ShippingMethod.STANDARD);
    }

    @Test
    void testProcessOrderRegularCustomer() {
        double finalPrice = orderManager.processOrder(order);
        assertEquals(131.18, finalPrice, 0.01);
    }

    @Test
    void testProcessOrderPremiumCustomer() {
        order.setCustomerType(CustomerType.PREMIUM);
        double finalPrice = orderManager.processOrder(order);
        assertEquals(124.225, finalPrice, 0.01);
    }

    @Test
    void testProcessOrderInternationalShipping() {
        Address canadaAddress = new Address();
        canadaAddress.setCountry("Canada");
        order.setShippingAddress(canadaAddress);
        double finalPrice = orderManager.processOrder(order);
        assertEquals(138.20, finalPrice, 0.01);
    }

    @Test
    void testProcessOrderExpressShipping() {
        order.setShippingMethod(ShippingMethod.EXPRESS);
        double finalPrice = orderManager.processOrder(order);
        assertEquals(141.18, finalPrice, 0.01);
    }
}