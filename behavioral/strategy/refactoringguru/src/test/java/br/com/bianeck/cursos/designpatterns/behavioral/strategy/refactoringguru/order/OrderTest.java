package br.com.bianeck.cursos.designpatterns.behavioral.strategy.refactoringguru.order;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.bianeck.cursos.designpatterns.behavioral.strategy.refactoringguru.strategies.PayByCreditCard;
import br.com.bianeck.cursos.designpatterns.behavioral.strategy.refactoringguru.strategies.PayByPayPal;
import br.com.bianeck.cursos.designpatterns.behavioral.strategy.refactoringguru.strategies.PayStrategy;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testOrderProcessingWithPayPal() {
        PayStrategy paypalStrategy = mock(PayByPayPal.class);
        when(paypalStrategy.pay(anyInt())).thenReturn(true);

        order.setTotalCost(6250); // Simulando a compra de produtos
        order.processOrder(paypalStrategy);

        verify(paypalStrategy).collectPaymentDetails();
        assertTrue(paypalStrategy.pay(order.getTotalCost()));
        
        order.setClosed();
        assertTrue(order.isClosed());
    }

    @Test
    void testOrderProcessingWithCreditCard() {
        PayStrategy creditCardStrategy = mock(PayByCreditCard.class);
        when(creditCardStrategy.pay(anyInt())).thenReturn(true);

        order.setTotalCost(4050); // Simulando a compra de produtos
        order.processOrder(creditCardStrategy);

        verify(creditCardStrategy).collectPaymentDetails();
        assertTrue(creditCardStrategy.pay(order.getTotalCost()));
        
        order.setClosed();
        assertTrue(order.isClosed());
    }

    @Test
    void testPayPalPaymentFlow() {
        String input = "amanda@ya.com\namanda1985\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PayByPayPal paypalStrategy = new PayByPayPal();
        order.setTotalCost(6250);

        paypalStrategy.collectPaymentDetails();
        boolean paymentResult = paypalStrategy.pay(order.getTotalCost());

        assertTrue(paymentResult);
    }

    @Test
    void testCreditCardPaymentFlow() {
        String input = "1234567890123456\n12/25\n123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PayByCreditCard creditCardStrategy = new PayByCreditCard();
        order.setTotalCost(4050);

        creditCardStrategy.collectPaymentDetails();
        boolean paymentResult = creditCardStrategy.pay(order.getTotalCost());

        assertTrue(paymentResult);
    }

    @Test
    void testMultipleProductsOrder() {
        order.setTotalCost(2200); // Mother board
        order.setTotalCost(1850); // CPU
        assertEquals(4050, order.getTotalCost());

        PayStrategy mockStrategy = mock(PayStrategy.class);
        when(mockStrategy.pay(anyInt())).thenReturn(true);

        order.processOrder(mockStrategy);
        verify(mockStrategy).collectPaymentDetails();
        assertTrue(mockStrategy.pay(order.getTotalCost()));
    }

    @Test
    void testFailedPayment() {
        PayStrategy failingStrategy = mock(PayStrategy.class);
        when(failingStrategy.pay(anyInt())).thenReturn(false);

        order.setTotalCost(10000); // Um valor alto para simular uma falha
        order.processOrder(failingStrategy);

        verify(failingStrategy).collectPaymentDetails();
        assertFalse(failingStrategy.pay(order.getTotalCost()));
        assertFalse(order.isClosed());
    }
}