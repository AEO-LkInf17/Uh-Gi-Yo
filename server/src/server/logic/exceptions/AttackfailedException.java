package server.logic.exceptions;

public class AttackfailedException extends Exception {
    public AttackfailedException(){
        super("Attack failed");
    }
}
