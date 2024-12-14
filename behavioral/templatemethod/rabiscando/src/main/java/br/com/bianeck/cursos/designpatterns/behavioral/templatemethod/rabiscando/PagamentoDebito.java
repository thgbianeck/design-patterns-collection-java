package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.rabiscando;

/**
 * A classe PagamentoDebito representa uma transação de pagamento com cartão de débito.
 * <p>
 * Esta classe é responsável por calcular taxas, descontos e realizar a cobrança
 * para pagamentos feitos com cartão de débito. Ela utiliza um objeto Gateway
 * para processar a cobrança final.
 * </p>
 *
 * @author Seu Nome
 * @version 1.0
 * @since 2023-XX-XX
 */
public class PagamentoDebito {
    private float valor;
    private Gateway gateway;

    /**
     * Construtor para criar uma nova instância de PagamentoDebito.
     *
     * @param valor   O valor do pagamento a ser processado.
     * @param gateway O objeto Gateway a ser utilizado para processar a cobrança.
     */
    public PagamentoDebito(float valor, Gateway gateway) {
        this.valor = valor;
        this.gateway = gateway;
    }

    /**
     * Calcula a taxa aplicada ao pagamento com cartão de débito.
     * <p>
     * Para pagamentos com débito, é aplicada uma taxa fixa de 4 reais,
     * independentemente do valor da transação.
     * </p>
     *
     * @return float O valor da taxa fixa (4 reais).
     */
    public float calcularTaxa() {
        return 4f;
    }

    /**
     * Calcula o desconto aplicado ao pagamento com cartão de débito.
     * <p>
     * Para pagamentos com débito, é aplicado um desconto fixo de 5%
     * sobre o valor total da transação.
     * </p>
     *
     * @return float O valor do desconto calculado (5% do valor da transação).
     */
    public float calcularDesconto() {
        return this.valor * 0.05f;
    }

    /**
     * Realiza a cobrança do pagamento com cartão de débito.
     * <p>
     * Este método calcula o valor final do pagamento, considerando o valor original,
     * a taxa fixa aplicada e o desconto. Em seguida, delega a cobrança
     * para o objeto Gateway.
     * </p>
     *
     * @return boolean Retorna true se a cobrança foi bem-sucedida, false caso contrário.
     */
    public boolean realizaCobranca() {
        float valorFinal = this.valor + this.calcularTaxa() - this.calcularDesconto();
        return this.gateway.cobrar(valorFinal);
    }
}