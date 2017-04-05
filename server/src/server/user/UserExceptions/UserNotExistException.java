package server.user.UserExceptions;

public class UserNotExistException extends Exception {
    public UserNotExistException() {
        super("User doesnt exist!");
    }
}
