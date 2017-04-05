package server.user.UserExceptions;

public class UserIsOnlineException extends Exception {
    public UserIsOnlineException() {
        super("User is already online!");
    }
}