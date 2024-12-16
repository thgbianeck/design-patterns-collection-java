package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.rabiscando.after;

public class PagamentoDinheiroAF extends PagamentoAF{
    
    public PagamentoDinheiroAF(float valor, GatewayAF gateway) {
        super(valor, gateway);
    }

    public float calcularDesconto() {
        return this.valor * 0.1f;
    }
    
}