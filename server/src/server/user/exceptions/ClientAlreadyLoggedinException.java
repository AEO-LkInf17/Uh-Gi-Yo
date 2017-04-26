package server.user.exceptions;

public class ClientAlreadyLoggedinException extends Exception {
    public ClientAlreadyLoggedinException() {
        super("UserIsAlreadyLoggedin!");
    }
}
