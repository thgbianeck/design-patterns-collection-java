package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.rabiscando.after;


public class PagamentoCreditoAF extends PagamentoAF{
    
    public PagamentoCreditoAF(float valor, GatewayAF gateway) {
        super(valor, gateway);
    }
    
    public float calcularTaxa() {
        return this.valor * 0.05f;
    }
    
    public float calcularDesconto() {
        if (this.valor > 300) {
            return this.valor * 0.02f;
        }
        return 0;
    }
    
}