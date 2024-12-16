package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.rabiscando.before;

import java.util.Random;

/**
 * A classe Gateway simula um gateway de pagamento.
 * <p>
 * Esta classe é responsável por processar cobranças de pagamentos,
 * simulando o comportamento de um gateway de pagamento real.
 * Para fins de demonstração e teste, o resultado da cobrança
 * é determinado aleatoriamente.
 * </p>
 *
 * @author Seu Nome
 * @version 1.0
 * @since 2023-XX-XX
 */
public class GatewayBF {
    
    /**
     * Simula o processamento de uma cobrança.
     * <p>
     * Este método simula o processamento de uma cobrança por um gateway de pagamento.
     * O resultado da cobrança é determinado aleatoriamente, retornando true (aprovado)
     * ou false (recusado) com igual probabilidade.
     * </p>
     * <p>
     * Em um cenário real, este método se comunicaria com um serviço de pagamento
     * externo e retornaria o resultado real da transação.
     * </p>
     *
     * @param valor O valor da cobrança a ser processada. Atualmente, este parâmetro
     *              não influencia o resultado da cobrança, mas está incluído para
     *              simular a interface de um gateway real.
     * @return boolean Retorna true se a cobrança foi aprovada, ou false se foi recusada.
     *                 O resultado é determinado aleatoriamente.
     */
    public boolean cobrar(double valor) {
        Random random = new Random();
        return random.nextBoolean();
    }
}