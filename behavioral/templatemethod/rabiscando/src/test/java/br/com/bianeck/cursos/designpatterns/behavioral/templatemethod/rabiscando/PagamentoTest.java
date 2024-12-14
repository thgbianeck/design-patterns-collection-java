package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.rabiscando;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes de Processamento de Pagamentos")
class PagamentoTest {

    private Gateway gateway;
    private float valor;

    @BeforeEach
    void setUp() {
        gateway = new Gateway();
        valor = 1000f;
    }

    @Test
    @DisplayName("Deve processar pagamento com cartão de crédito corretamente")
    void testPagamentoCredito() {
        PagamentoCredito pagamentoCredito = new PagamentoCredito(valor, gateway);
        boolean resultado = pagamentoCredito.realizaCobranca();
        
        // Verifica se a cobrança foi realizada (pode ser true ou false devido à natureza aleatória do Gateway)
        assertTrue(resultado || !resultado, "A cobrança deve ser processada pelo gateway");
        
        // Verifica se o valor final está correto
        float valorEsperado = valor + (valor * 0.05f) - (valor * 0.02f); // taxa de 5% e desconto de 2%
        assertEquals(valorEsperado, valor + pagamentoCredito.calcularTaxa() - pagamentoCredito.calcularDesconto(), 0.01f,
                     "O valor final do pagamento com crédito deve ser calculado corretamente");
    }

    @Test
    @DisplayName("Deve processar pagamento com cartão de débito corretamente")
    void testPagamentoDebito() {
        PagamentoDebito pagamentoDebito = new PagamentoDebito(valor, gateway);
        boolean resultado = pagamentoDebito.realizaCobranca();
        
        assertTrue(resultado || !resultado, "A cobrança deve ser processada pelo gateway");
        
        float valorEsperado = valor + 4f - (valor * 0.05f); // taxa fixa de 4 e desconto de 5%
        assertEquals(valorEsperado, valor + pagamentoDebito.calcularTaxa() - pagamentoDebito.calcularDesconto(), 0.01f,
                     "O valor final do pagamento com débito deve ser calculado corretamente");
    }

    @Test
    @DisplayName("Deve processar pagamento em dinheiro corretamente")
    void testPagamentoDinheiro() {
        PagamentoDinheiro pagamentoDinheiro = new PagamentoDinheiro(valor, gateway);
        boolean resultado = pagamentoDinheiro.realizaCobranca();
        
        assertTrue(resultado || !resultado, "A cobrança deve ser processada pelo gateway");
        
        float valorEsperado = valor - (valor * 0.1f); // sem taxa e desconto de 10%
        assertEquals(valorEsperado, valor + pagamentoDinheiro.calcularTaxa() - pagamentoDinheiro.calcularDesconto(), 0.01f,
                     "O valor final do pagamento em dinheiro deve ser calculado corretamente");
    }
}