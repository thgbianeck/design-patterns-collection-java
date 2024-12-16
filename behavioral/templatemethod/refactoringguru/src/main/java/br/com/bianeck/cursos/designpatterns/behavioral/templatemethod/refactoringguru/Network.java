package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.refactoringguru;

public abstract class Network {

    protected String username;
    protected String password;

    public Network() {
    }

    public boolean post(String message){
        return false;
    }

    abstract boolean logIn(String username,String password);
    abstract boolean sendData(byte[] data);
    abstract void logOut();

    protected void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
