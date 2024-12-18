package br.com.bianeck.cursos.designpatterns.behavioral.observer.rabiscando;

public class Funcionario implements Observer {
    private String nome;
    private String email;
    private Subject subject;

    public Funcionario(String nome, String email, Subject subject) {
        this.nome = nome;
        this.email = email;
        this.subject = subject;
        this.subject.registerObserver(this);
        this.subject.removeObserver(this);
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