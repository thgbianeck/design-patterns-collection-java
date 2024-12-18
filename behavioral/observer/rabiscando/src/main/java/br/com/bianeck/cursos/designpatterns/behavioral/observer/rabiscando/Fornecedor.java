package br.com.bianeck.cursos.designpatterns.behavioral.observer.rabiscando;

public class Fornecedor implements Observer {
    private String nome;
    private String email;
    private Subject subject;

    public Fornecedor(String nome, String email, Subject subject) {
        this.nome = nome;
        this.email = email;
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(String mensagem) {
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
