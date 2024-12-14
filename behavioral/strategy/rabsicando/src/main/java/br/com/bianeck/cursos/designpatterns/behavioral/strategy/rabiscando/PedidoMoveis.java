package br.com.bianeck.cursos.designpatterns.behavioral.strategy.rabiscando;

public class PedidoMoveis extends Pedido {

    // Campo privado para armazenar o nome do setor
    private String nomeSetor;

    // Construtor que inicializa o nome do setor
    public PedidoMoveis() {
        this.nomeSetor = "Móveis";
    }

    // Método público para obter o nome do setor
    public String getNomeSetor() {
        return nomeSetor;
    }

    // Método público para definir o nome do setor
    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
}