package br.com.bianeck.cursos.designpatterns.behavioral.observer.rabiscando;

public class Cliente implements Observer {
    private String nome;
    private String email;
    private Subject subject;

    // O subject é recebido por parâmetro para que o cliente tenha acesso a ele.
    public Cliente(String nome, String email, Subject subject) {
        this.nome = nome;
        this.email = email;
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(String mensagem) {
        // Faz o envio da mensagem para o email.
        Email.enviarEmail(this, mensagem);
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getEmail() {
        return this.email;
    }
}
