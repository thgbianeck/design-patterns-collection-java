package br.com.bianeck.cursos.designpatterns.behavioral.strategy.before;

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
        double total = calculateTotal(order);
        applyDiscount(order, total);
        calculateTax(order);
        calculateShipping(order);
        return order.getFinalPrice();
    }

    /**
     * Calcula o total do pedido somando o preço de todos os itens.
     *
     * @param order O pedido para o qual calcular o total.
     * @return O total calculado.
     */
    private double calculateTotal(Order order) {
        double total = 0;
        for (OrderItem item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        order.setSubtotal(total);
        return total;
    }

    /**
     * Aplica descontos ao pedido com base no tipo de cliente e no total.
     *
     * @param order O pedido ao qual aplicar o desconto.
     * @param total O total do pedido antes do desconto.
     */
    private void applyDiscount(Order order, double total) {
        if (order.getCustomerType() == CustomerType.REGULAR) {
            if (total > 100) {
                order.setDiscount(total * 0.1);
            }
        } else if (order.getCustomerType() == CustomerType.PREMIUM) {
            if (total > 100) {
                order.setDiscount(total * 0.15);
            } else {
                order.setDiscount(total * 0.05);
            }
        } else if (order.getCustomerType() == CustomerType.VIP) {
            order.setDiscount(total * 0.20);
        }
    }

    /**
     * Calcula o imposto para o pedido com base no país de entrega.
     *
     * @param order O pedido para o qual calcular o imposto.
     */
    private void calculateTax(Order order) {
        double taxRate = 0;
        if (order.getShippingAddress().getCountry().equals("USA")) {
            taxRate = 0.07;
        } else if (order.getShippingAddress().getCountry().equals("Canada")) {
            taxRate = 0.13;
        }
        order.setTax((order.getSubtotal() - order.getDiscount()) * taxRate);
    }

    /**
     * Calcula o custo de envio com base no método de envio escolhido.
     *
     * @param order O pedido para o qual calcular o custo de envio.
     */
    private void calculateShipping(Order order) {
        double shippingCost = 0;
        if (order.getShippingMethod() == ShippingMethod.STANDARD) {
            shippingCost = 5.99;
        } else if (order.getShippingMethod() == ShippingMethod.EXPRESS) {
            shippingCost = 15.99;
        } else if (order.getShippingMethod() == ShippingMethod.OVERNIGHT) {
            shippingCost = 29.99;
        }
        order.setShippingCost(shippingCost);
    }
}