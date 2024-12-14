package br.com.bianeck.cursos.designpatterns.behavioral.strategy.rabiscando;

// Implementação do frete expresso
public class FreteExpresso implements Frete {
    // Método que implementa o cálculo do frete expresso
    @Override
    public float calcula(float valorPedido) {
        return valorPedido * 0.1f; // O frete expresso custa 10% do valor do pedido
    }
}