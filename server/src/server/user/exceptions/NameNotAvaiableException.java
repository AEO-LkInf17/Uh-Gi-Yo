package server.user.exceptions;

public class NameNotAvaiableException extends Exception {
    public NameNotAvaiableException() {
        super("Name is not avaiable!");
    }
}