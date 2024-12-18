package br.com.bianeck.cursos.designpatterns.behavioral.observer.rabiscando;

public class Email {
    public static void enviarEmail(Observer observer, String mensagem) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Email enviado para " + observer.getNome() + " - " + observer.getEmail());
        System.out.println("Mensagem: " + mensagem + "\n");
    }
}