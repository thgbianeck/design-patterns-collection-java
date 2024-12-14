package br.com.bianeck.cursos.designpatterns.behavioral.strategy.rabiscando;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PedidoTest {

    private Frete freteComum;
    private Frete freteExpresso;
    private PedidoEletronicos pedidoEletronicos;
    private PedidoMoveis pedidoMoveis;

    @BeforeEach
    public void setUp() {
        // Mock dos tipos de frete
        freteComum = mock(FreteComum.class);
        freteExpresso = mock(FreteExpresso.class);

        // Criação de um pedido do setor de eletrônicos
        pedidoEletronicos = new PedidoEletronicos();
        // Criação de um pedido do setor de móveis
        pedidoMoveis = new PedidoMoveis();
    }

    @Test
    public void testFreteComumEletronicos() {
        // Configuração do mock
        when(freteComum.calcula(100)).thenReturn(5.0f);

        // Atribuição do valor e tipo de frete
        pedidoEletronicos.setValor(100);
        pedidoEletronicos.setTipoFrete(freteComum);

        // Verificação do cálculo
        assertEquals(5.0f, pedidoEletronicos.calculaFrete());

        // Verificando que o método foi chamado corretamente
        verify(freteComum).calcula(100);
    }

    @Test
    public void testFreteExpressoEletronicos() {
        // Configuração do mock
        when(freteExpresso.calcula(100)).thenReturn(10.0f);

        // Atribuição do valor e tipo de frete
        pedidoEletronicos.setValor(100);
        pedidoEletronicos.setTipoFrete(freteExpresso);

        // Verificação do cálculo
        assertEquals(10.0f, pedidoEletronicos.calculaFrete());

        // Verificando que o método foi chamado corretamente
        verify(freteExpresso).calcula(100);
    }

    @Test
    public void testFreteComumMoveis() {
        // Configuração do mock
        when(freteComum.calcula(100)).thenReturn(5.0f);

        // Atribuição do valor e tipo de frete
        pedidoMoveis.setValor(100);
        pedidoMoveis.setTipoFrete(freteComum);

        // Verificação do cálculo
        assertEquals(5.0f, pedidoMoveis.calculaFrete());

        // Verificando que o método foi chamado corretamente
        verify(freteComum).calcula(100);
    }
}
