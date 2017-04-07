package server.user.exceptions;

public class UserIsOnlineException extends Exception {
    public UserIsOnlineException() {
        super("User is already online!");
    }
}
