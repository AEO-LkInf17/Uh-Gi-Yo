package server.user.exceptions;

public class UserNotExistException extends Exception {
    public UserNotExistException() {
        super("User doesnt exist!");
    }
}
