package br.com.bianeck.cursos.designpatterns.behavioral.strategy.before;

import java.util.List;

/**
 * Representa um pedido no sistema de e-commerce.
 * Esta classe encapsula todas as informações relevantes para um pedido,
 * incluindo itens, tipo de cliente, endereço de entrega, método de envio,
 * e cálculos financeiros relacionados.
 */
public class Order {
    // Atributos do pedido
    private List<OrderItem> items;           // Lista de itens do pedido
    private CustomerType customerType;       // Tipo de cliente que fez o pedido
    private Address shippingAddress;         // Endereço de entrega
    private ShippingMethod shippingMethod;   // Método de envio escolhido
    private double subtotal;                 // Valor total dos itens antes de descontos e taxas
    private double discount;                 // Valor do desconto aplicado
    private double tax;                      // Valor do imposto aplicado
    private double shippingCost;             // Custo de envio

    /**
     * Retorna a lista de itens do pedido.
     * @return List<OrderItem> contendo os itens do pedido.
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * Define a lista de itens do pedido.
     * @param items List<OrderItem> a ser definida como itens do pedido.
     */
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    /**
     * Retorna o tipo de cliente que fez o pedido.
     * @return CustomerType do cliente.
     */
    public CustomerType getCustomerType() {
        return customerType;
    }

    /**
     * Define o tipo de cliente que fez o pedido.
     * @param customerType CustomerType a ser definido.
     */
    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    /**
     * Retorna o endereço de entrega do pedido.
     * @return Address de entrega.
     */
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Define o endereço de entrega do pedido.
     * @param shippingAddress Address a ser definido como endereço de entrega.
     */
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Retorna o método de envio escolhido para o pedido.
     * @return ShippingMethod escolhido.
     */
    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    /**
     * Define o método de envio para o pedido.
     * @param shippingMethod ShippingMethod a ser definido.
     */
    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    /**
     * Retorna o subtotal do pedido (soma dos preços dos itens).
     * @return double representando o subtotal.
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Define o subtotal do pedido.
     * @param subtotal double a ser definido como subtotal.
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Retorna o valor do desconto aplicado ao pedido.
     * @return double representando o desconto.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Define o valor do desconto para o pedido.
     * @param discount double a ser definido como desconto.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Retorna o valor do imposto aplicado ao pedido.
     * @return double representando o imposto.
     */
    public double getTax() {
        return tax;
    }

    /**
     * Define o valor do imposto para o pedido.
     * @param tax double a ser definido como imposto.
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     * Retorna o custo de envio do pedido.
     * @return double representando o custo de envio.
     */
    public double getShippingCost() {
        return shippingCost;
    }

    /**
     * Define o custo de envio para o pedido.
     * @param shippingCost double a ser definido como custo de envio.
     */
    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    /**
     * Calcula e retorna o preço final do pedido.
     * O preço final é calculado como: subtotal - desconto + imposto + custo de envio.
     * @return double representando o preço final do pedido.
     */
    public double getFinalPrice() {
        return subtotal - discount + tax + shippingCost;
    }
}