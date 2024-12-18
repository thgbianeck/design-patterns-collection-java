package br.com.bianeck.cursos.designpatterns.behavioral.observer.rabiscando;

import java.util.ArrayList;
import java.util.List;

public class Newsletter implements Subject {
    private List<Observer> observers;
    private List<String> mensagens;

    public Newsletter() {
        this.observers = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }

    /* Adiciona um objeto a lista de observers a serem notificados
       quando uma nova mensagem for inserida na newsletter. */
    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    /* Remove um objeto a lista de observers a serem notificados
       quando uma nova mensagem for inserida na newsletter. */
    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    // Notifica todos os observer sobre a nova mensagem da newsletter.
    @Override
    public void notifyObservers() {
        String lastMessage = this.mensagens.get(this.mensagens.size() - 1);
        for (Observer o : this.observers) {
            o.update(lastMessage);
        }
    }

    /* Adiciona uma nova mensagem a newsletter e solicita que todos
       os observers sejam notificados */
    public void addMensagem(String mensagem) {
        this.mensagens.add(mensagem);
        this.notifyObservers();
    }
}
