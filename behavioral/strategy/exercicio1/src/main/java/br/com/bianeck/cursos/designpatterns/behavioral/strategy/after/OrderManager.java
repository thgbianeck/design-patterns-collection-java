package br.com.bianeck.cursos.designpatterns.behavioral.strategy.after;

/**
 * Gerencia o processamento de pedidos, incluindo cálculos de total,
 * descontos, impostos e custos de envio.
 */
public class OrderManager {

    /**
     * Processa um pedido, realizando todos os cálculos necessários.
     *
     * @param order O pedido a ser processado.
     * @return O preço final do pedido após todos os cálculos.
     */
    public double processOrder(Order order) {
        order.calculateTotal();
        order.applyDiscount();
        order.calculateTax();
        order.calculateShipping();
        return order.getFinalPrice();
    }

}