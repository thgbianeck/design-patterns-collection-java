package br.com.bianeck.cursos.designpatterns.behavioral.strategy.refactoringguru.strategies;

/**
 * Common interface for all strategies.
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}