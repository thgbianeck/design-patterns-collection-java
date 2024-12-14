package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.rabiscando;

/**
 * A classe PagamentoCredito representa uma transação de pagamento com cartão de crédito.
 * <p>
 * Esta classe é responsável por calcular taxas, descontos e realizar a cobrança
 * para pagamentos feitos com cartão de crédito. Ela utiliza um objeto Gateway
 * para processar a cobrança final.
 * </p>
 *
 * @author Seu Nome
 * @version 1.0
 * @since 2023-XX-XX
 */
public class PagamentoCredito {
    private float valor;
    private Gateway gateway;

    /**
     * Construtor para criar uma nova instância de PagamentoCredito.
     *
     * @param valor   O valor do pagamento a ser processado.
     * @param gateway O objeto Gateway a ser utilizado para processar a cobrança.
     */
    public PagamentoCredito(float valor, Gateway gateway) {
        this.valor = valor;
        this.gateway = gateway;
    }

    /**
     * Calcula a taxa aplicada ao pagamento com cartão de crédito.
     * <p>
     * A taxa é calculada como 5% do valor do pagamento.
     * </p>
     *
     * @return float O valor da taxa calculada.
     */
    public float calcularTaxa() {
        return this.valor * 0.05f;
    }

    /**
     * Calcula o desconto aplicado ao pagamento com cartão de crédito.
     * <p>
     * Se o valor do pagamento for maior que 300 reais, um desconto de 2% é aplicado.
     * Caso contrário, nenhum desconto é aplicado.
     * </p>
     *
     * @return float O valor do desconto calculado.
     */
    public float calcularDesconto() {
        if (this.valor > 300) {
            return this.valor * 0.02f;
        }
        return 0;
    }

    /**
     * Realiza a cobrança do pagamento com cartão de crédito.
     * <p>
     * Este método calcula o valor final do pagamento, considerando o valor original,
     * a taxa aplicada e o desconto (se houver). Em seguida, delega a cobrança
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