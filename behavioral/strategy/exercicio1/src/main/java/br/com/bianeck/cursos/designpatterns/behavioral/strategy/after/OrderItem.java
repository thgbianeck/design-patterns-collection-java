package br.com.bianeck.cursos.designpatterns.behavioral.strategy.after;

/**
 * Representa um item individual dentro de um pedido.
 * Esta classe encapsula as informações essenciais de um produto
 * no contexto de um pedido, incluindo nome, preço e quantidade.
 */
public class OrderItem {
    // Atributos do item do pedido
    private String productName;  // Nome do produto
    private double price;        // Preço unitário do produto
    private int quantity;        // Quantidade do produto no pedido

    /**
     * Construtor para criar um novo item de pedido.
     * 
     * @param productName Nome do produto.
     * @param price Preço unitário do produto.
     * @param quantity Quantidade do produto no pedido.
     */
    public OrderItem(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    
    /**
     * Obtém o nome do produto.
     * 
     * @return String representando o nome do produto.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Define o nome do produto.
     * 
     * @param productName String com o novo nome do produto.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Obtém o preço unitário do produto.
     * 
     * @return double representando o preço unitário.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Define o preço unitário do produto.
     * 
     * @param price double com o novo preço unitário.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Obtém a quantidade do produto no pedido.
     * 
     * @return int representando a quantidade.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Define a quantidade do produto no pedido.
     * 
     * @param quantity int com a nova quantidade.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Possível método adicional para calcular o subtotal do item
    /**
     * Calcula o subtotal para este item do pedido.
     * 
     * @return double representando o subtotal (preço * quantidade).
     */
    public double getSubtotal() {
        return price * quantity;
    }
}