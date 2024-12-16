package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.rabiscando.after;

public class PagamentoDebitoAF extends PagamentoAF{
    
    public PagamentoDebitoAF(float valor, GatewayAF gateway) {
        super(valor, gateway);
    }

    
    public float calcularTaxa() {
        return 4f;
    }

    
    public float calcularDesconto() {
        return this.valor * 0.05f;
    }
    
}