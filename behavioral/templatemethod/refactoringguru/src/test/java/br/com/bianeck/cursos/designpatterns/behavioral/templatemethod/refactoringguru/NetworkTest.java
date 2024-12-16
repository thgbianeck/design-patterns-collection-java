package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.refactoringguru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NetworkTest {

    private String userName;
    private String password;
    private Network network;
    private byte[] bytes;

    @BeforeEach
    public void setUp() {
        userName = "Thiago Bianeck";
        password = "secret1234";
        network = null;
        bytes = new byte[]{1, 2, 3, 4, 5};
    }

    @Test
    public void testLoginTwitter() {
        network = new Twitter(userName, password);
        boolean logged = network.logIn(userName, password);

        Assertions.assertTrue(logged);
    }

    @Test
    public void testLoginFacebook() {
        network = new Facebook(userName, password);
        boolean logged = network.logIn(userName, password);

        Assertions.assertTrue(logged);
    }


    @Test
    public void testSendDataTwitter() {
        network = new Twitter(userName, password);
        boolean logged = network.logIn(userName, password);
        boolean dataSended = network.sendData(bytes);

        Assertions.assertTrue(logged);
        Assertions.assertTrue(dataSended);

    }

    @Test
    public void testSendDataFacebook() {
        network = new Facebook(userName, password);
        boolean logged = network.logIn(userName, password);
        boolean dataSended = network.sendData(bytes);

        Assertions.assertTrue(logged);
        Assertions.assertTrue(dataSended);
    }
}
