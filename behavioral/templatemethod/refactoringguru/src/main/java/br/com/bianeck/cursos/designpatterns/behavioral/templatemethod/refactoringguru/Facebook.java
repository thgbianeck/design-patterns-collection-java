package br.com.bianeck.cursos.designpatterns.behavioral.templatemethod.refactoringguru;

public class Facebook extends Network{

    public Facebook(String username, String password){
        this.username = username;
        this.password = password;
    }

    boolean logIn(String username, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.username);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on Facebook");
        return true;
    }

    boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            System.out.println("Message: '" + new String(data) + "' was posted on Facebook");
            return true;
        } else {
            return false;
        }
    }

    void logOut() {
        System.out.println("User: '" + username + "' was logged out from Facebook");
    }
 

}
