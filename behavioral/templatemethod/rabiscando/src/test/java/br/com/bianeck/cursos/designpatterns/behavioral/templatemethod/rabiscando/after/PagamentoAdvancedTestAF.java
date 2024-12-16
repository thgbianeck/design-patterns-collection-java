package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.rabiscando.after;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;

@DisplayName("Testes Avançados de Pagamento")
class PagamentoAdvancedTestAF {

    private GatewayAF gatewayMock;

    @BeforeEach
    void setUp() {
        gatewayMock = Mockito.mock(GatewayAF.class);
        Mockito.when(gatewayMock.cobrar(anyDouble())).thenReturn(true);
    }

    @ParameterizedTest
    @ValueSource(floats = {299.99f, 300f, 300.01f})
    @DisplayName("Deve calcular desconto corretamente para valores próximos ao limite no PagamentoCredito")
    void testPagamentoCreditoLimiteDesconto(float valor) {
        PagamentoCreditoAF pagamentoCredito = new PagamentoCreditoAF(valor, gatewayMock);
        float desconto = pagamentoCredito.calcularDesconto();
        
        if (valor > 300) {
            assertEquals(valor * 0.02f, desconto, 0.01f, "Desconto deve ser 2% para valores acima de 300");
        } else {
            assertEquals(0f, desconto, 0.01f, "Não deve haver desconto para valores até 300");
        }
    }

    @Test
    @DisplayName("Deve calcular taxa corretamente para PagamentoDebito")
    void testPagamentoDebitoTaxa() {
        PagamentoDebitoAF pagamentoDebito = new PagamentoDebitoAF(1000f, gatewayMock);
        assertEquals(4f, pagamentoDebito.calcularTaxa(), "Taxa de débito deve ser fixa em 4");
    }

    @Test
    @DisplayName("Deve calcular desconto corretamente para PagamentoDinheiro")
    void testPagamentoDinheiroDesconto() {
        float valor = 500f;
        PagamentoDinheiroAF pagamentoDinheiro = new PagamentoDinheiroAF(valor, gatewayMock);
        assertEquals(valor * 0.1f, pagamentoDinheiro.calcularDesconto(), 0.01f, "Desconto em dinheiro deve ser 10%");
    }

    @Test
    @DisplayName("Deve lidar corretamente com valor zero")
    void testValorZero() {
        PagamentoCreditoAF pagamentoCredito = new PagamentoCreditoAF(0f, gatewayMock);
        assertTrue(pagamentoCredito.realizaCobranca(), "Deve ser possível realizar cobrança de valor zero");
        assertEquals(0f, pagamentoCredito.calcularTaxa(), "Taxa deve ser zero para valor zero");
        assertEquals(0f, pagamentoCredito.calcularDesconto(), "Desconto deve ser zero para valor zero");
    }

    @Test
    @DisplayName("Deve chamar o gateway corretamente")
    void testChamadaGateway() {
        float valor = 1000f;
        PagamentoCreditoAF pagamentoCredito = new PagamentoCreditoAF(valor, gatewayMock);
        pagamentoCredito.realizaCobranca();
        
        float valorEsperado = valor + (valor * 0.05f) - (valor * 0.02f);
        Mockito.verify(gatewayMock).cobrar(valorEsperado);
    }

    @Test
    @DisplayName("Deve manter precisão em cálculos com muitas casas decimais")
    void testPrecisaoCalculos() {
        float valor = 33.33f;
        PagamentoCreditoAF pagamentoCredito = new PagamentoCreditoAF(valor, gatewayMock);
        float valorFinal = valor + pagamentoCredito.calcularTaxa() - pagamentoCredito.calcularDesconto();
        assertEquals(34.9965f, valorFinal, 0.0001f, "Deve manter precisão em cálculos com muitas casas decimais");
    }
}
