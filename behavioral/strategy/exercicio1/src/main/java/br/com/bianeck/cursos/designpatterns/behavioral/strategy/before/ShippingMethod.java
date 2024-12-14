package br.com.bianeck.cursos.designpatterns.behavioral.strategy.before;

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
    STANDARD,

    /**
     * Representa o método de envio expresso.
     * Oferece um equilíbrio entre velocidade e custo, sendo mais rápido que o padrão,
     * mas não tão rápido quanto o envio noturno.
     */
    EXPRESS,

    /**
     * Representa o método de envio noturno.
     * É a opção mais rápida disponível, garantindo entrega no dia seguinte,
     * mas geralmente é a mais cara.
     */
    OVERNIGHT
}