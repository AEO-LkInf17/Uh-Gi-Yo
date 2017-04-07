package server.logic.exceptions;

public class SubtractLifepointsException extends Exception {
    public SubtractLifepointsException (int amount){
        super("amount");
    }
}
