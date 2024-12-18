package br.com.bianeck.cursos.designpatterns.behavioral.observer.rabiscando;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ObserverTest {

    private Newsletter newsletter;
    private Funcionario funcionario1, funcionario2;
    private Cliente cliente;
    private Parceiro parceiro;
    private Fornecedor fornecedor;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        newsletter = new Newsletter();
        funcionario1 = new Funcionario("Funcionario 1", "funcionario1@email.com", newsletter);
        funcionario2 = new Funcionario("Funcionario 2", "funcionario2@email.com", newsletter);
        cliente = new Cliente("Cliente 1", "cliente1@email.com", newsletter);
        parceiro = new Parceiro("Parceiro 1", "parceiro1@email.com", newsletter);
        fornecedor = new Fornecedor("Fornecedor 1", "fornecedor1@email.com", newsletter);

        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Deve notificar todos os observadores ao adicionar primeira mensagem")
    void deveNotificarTodosObservadoresAoAdicionarPrimeiraMensagem() {
        newsletter.addMensagem("Primeira Mensagem");

        String output = outputStreamCaptor.toString();
        System.out.println("output :: " + output);
        assertTrue(output.contains("Email enviado para Cliente 1 - cliente1@email.com"));
        assertTrue(output.contains("Email enviado para Parceiro 1 - parceiro1@email.com"));
        assertTrue(output.contains("Email enviado para Fornecedor 1 - fornecedor1@email.com"));
        assertTrue(output.contains("Mensagem: Primeira Mensagem"));
    }

    @Test
    @DisplayName("Não deve notificar observador removido ao adicionar segunda mensagem")
    void naoDeveNotificarObservadorRemovidoAoAdicionarSegundaMensagem() {
        newsletter.removeObserver(funcionario2);
        newsletter.addMensagem("Segunda Mensagem");

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Email enviado para Cliente 1 - cliente1@email.com"));
        assertTrue(output.contains("Email enviado para Parceiro 1 - parceiro1@email.com"));
        assertTrue(output.contains("Email enviado para Fornecedor 1 - fornecedor1@email.com"));
        assertTrue(output.contains("Mensagem: Segunda Mensagem"));
    }

    @Test
    @DisplayName("Deve notificar observador readicionado ao adicionar terceira mensagem")
    void deveNotificarObservadorReadicionadoAoAdicionarTerceiraMensagem() {
        newsletter.removeObserver(funcionario2);
        newsletter.registerObserver(funcionario2);
        newsletter.addMensagem("Terceira Mensagem");

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Email enviado para Cliente 1 - cliente1@email.com"));
        assertTrue(output.contains("Email enviado para Parceiro 1 - parceiro1@email.com"));
        assertTrue(output.contains("Email enviado para Fornecedor 1 - fornecedor1@email.com"));
        assertTrue(output.contains("Mensagem: Terceira Mensagem"));
    }
}