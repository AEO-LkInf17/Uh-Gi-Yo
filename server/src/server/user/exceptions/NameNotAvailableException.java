package server.user.exceptions;

public class NameNotAvailableException extends Exception {
    public NameNotAvaiableException() {
        super("Name is not available!");
    }
}
