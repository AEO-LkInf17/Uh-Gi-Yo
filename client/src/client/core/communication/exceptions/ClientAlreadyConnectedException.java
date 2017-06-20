package client.core.communication.exceptions;

public class ClientAlreadyConnectedException extends Exception {
    public ClientAlreadyConnectedException() {
        super("ClientAlreadyConnected!");
    }
}
