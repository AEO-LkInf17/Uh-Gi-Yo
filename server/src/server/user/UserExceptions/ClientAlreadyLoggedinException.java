package server.user.UserExceptions;

public class ClientAlreadyLoggedinException extends Exception {
    public ClientAlreadyLoggedinException() {
        super("UserIsAlreadyLoggedin!");
    }
}
