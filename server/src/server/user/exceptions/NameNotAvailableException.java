package server.user.exceptions;

public class NameNotAvailableException extends Exception {
    public NameNotAvailableException() {
         super("Name is not available!");
    }
}
