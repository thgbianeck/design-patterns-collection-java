package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.rabiscando.after;

abstract class PagamentoAF {
    protected float valor;
    protected GatewayAF gateway;

    public PagamentoAF(float valor, GatewayAF gateway) {
        this.valor = valor;
        this.gateway = gateway;
    }

    
    public float calcularTaxa() {
        return 0.0f;
    }

    
    abstract public float calcularDesconto();

    
    public final boolean realizaCobranca() {
        float valorFinal = this.valor + this.calcularTaxa() - this.calcularDesconto();
        return this.gateway.cobrar(valorFinal);
    }
}