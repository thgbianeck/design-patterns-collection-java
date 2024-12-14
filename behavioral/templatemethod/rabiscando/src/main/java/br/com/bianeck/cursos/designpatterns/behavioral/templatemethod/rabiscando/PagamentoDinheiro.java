package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.rabiscando;

/**
 * A classe PagamentoDinheiro representa uma transação de pagamento em dinheiro.
 * <p>
 * Esta classe é responsável por calcular descontos e realizar a cobrança
 * para pagamentos feitos em dinheiro. Embora pagamentos em dinheiro geralmente
 * não envolvam um gateway eletrônico, esta implementação utiliza um objeto Gateway
 * para simular o processamento da transação, possivelmente para fins de registro
 * ou integração com um sistema de ponto de venda.
 * </p>
 *
 * @author Seu Nome
 * @version 1.0
 * @since 2023-XX-XX
 */
public class PagamentoDinheiro {
    private float valor;
    private Gateway gateway;

    /**
     * Construtor para criar uma nova instância de PagamentoDinheiro.
     *
     * @param valor   O valor do pagamento a ser processado.
     * @param gateway O objeto Gateway a ser utilizado para simular o processamento da transação.
     */
    public PagamentoDinheiro(float valor, Gateway gateway) {
        this.valor = valor;
        this.gateway = gateway;
    }

    /**
     * Calcula a taxa aplicada ao pagamento em dinheiro.
     * <p>
     * Para pagamentos em dinheiro, não há taxa aplicada.
     * </p>
     *
     * @return float Sempre retorna 0, pois não há taxa para pagamentos em dinheiro.
     */
    public float calcularTaxa() {
        return 0f;
    }

    /**
     * Calcula o desconto aplicado ao pagamento em dinheiro.
     * <p>
     * Para pagamentos em dinheiro, é aplicado um desconto fixo de 10%
     * sobre o valor total da transação.
     * </p>
     *
     * @return float O valor do desconto calculado (10% do valor da transação).
     */
    public float calcularDesconto() {
        return this.valor * 0.1f;
    }

    /**
     * Simula a realização da cobrança do pagamento em dinheiro.
     * <p>
     * Este método calcula o valor final do pagamento, considerando o valor original
     * e o desconto aplicado. Em seguida, utiliza o objeto Gateway para simular
     * o processamento da transação. Em um cenário real de pagamento em dinheiro,
     * este método poderia ser usado para registrar a transação no sistema.
     * </p>
     *
     * @return boolean Retorna true se a simulação da cobrança foi bem-sucedida, false caso contrário.
     */
    public boolean realizaCobranca() {
        float valorFinal = this.valor + this.calcularTaxa() - this.calcularDesconto();
        return this.gateway.cobrar(valorFinal);
    }
}