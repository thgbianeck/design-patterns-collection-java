package br.com.bianeck.cursos.designpatterns.behavioral.refactoringguru.listeners;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}