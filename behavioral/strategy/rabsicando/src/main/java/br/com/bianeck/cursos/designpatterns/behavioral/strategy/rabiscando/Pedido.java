package br.com.bianeck.cursos.designpatterns.behavioral.strategy.rabiscando;

public abstract class Pedido {

    // Campo protegido para armazenar o valor do pedido
    protected float valor;
    protected Frete tipoFrete;

    // Método público para obter o valor do pedido
    public float getValor() {
        return valor;
    }

    // Método público para definir o valor do pedido
    public void setValor(float valor) {
        this.valor = valor;
    }

    // Método público para definir o tipo de frete
    public void setTipoFrete(Frete tipoFrete) {
        this.tipoFrete = tipoFrete;
    }

    // Método público para calcular o frete comum
    public float calculaFrete() {
        return this.tipoFrete.calcula(valor);
    }

}