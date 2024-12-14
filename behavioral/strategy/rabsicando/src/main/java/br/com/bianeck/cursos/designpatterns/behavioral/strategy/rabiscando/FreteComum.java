package br.com.bianeck.cursos.designpatterns.behavioral.strategy.rabiscando;

// Implementação do frete comum
public class FreteComum implements Frete {
    // Método que implementa o cálculo do frete comum
    @Override
    public float calcula(float valorPedido) {
        return valorPedido * 0.05f; // O frete comum custa 5% do valor do pedido
    }
}