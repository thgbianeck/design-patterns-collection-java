package br.com.bianeck.cursos.designpatterns.behavioral.strategy.after;

/**
 * Enumeração que representa os diferentes métodos de envio disponíveis para pedidos.
 * Esta enumeração é utilizada para definir as opções de envio que um cliente pode escolher
 * ao fazer um pedido, cada uma com diferentes tempos de entrega e custos associados.
 */
public enum ShippingMethod {
    /**
     * Representa o método de envio padrão.
     * Geralmente é a opção mais econômica, mas com um tempo de entrega mais longo.
     */
    STANDARD(5.99),

    /**
     * Representa o método de envio expresso.
     * Oferece um equilíbrio entre velocidade e custo, sendo mais rápido que o padrão,
     * mas não tão rápido quanto o envio noturno.
     */
    EXPRESS(15.99),

    /**
     * Representa o método de envio noturno.
     * É a opção mais rápida disponível, garantindo entrega no dia seguinte,
     * mas geralmente é a mais cara.
     */
    OVERNIGHT(29.99);

    private double shippingCost;

    ShippingMethod(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getShippingCost() {
        return shippingCost;
    }
}