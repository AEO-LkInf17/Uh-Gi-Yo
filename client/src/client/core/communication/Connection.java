package client.core.communication;

import client.core.communication.exceptions.ServerNotReachableException;

import java.io.IOException;
import java.net.Socket;

public class Connection {
    public static final int SERVER_PORT = 42042;

    private String ip;
    private Socket socket;

    public static final String LOGINSTATUS_LOGGEDIN = "LOGGEDIN";
    public static final String LOGINSTATUS_LOGGEDOUT = "LOGGEDOUT";

    private String logginstatus = LOGINSTATUS_LOGGEDOUT;

    public Connection(String ip) throws ServerNotReachableException {
        this.ip = ip;
        try {
            socket = new Socket(ip, SERVER_PORT);
        } catch (IOException e) {
            throw new ServerNotReachableException();
        }
    }
}