package br.com.bianeck.cursos.designpatterns.behavioral.observer.rabiscando;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
