package client.core.communication;

public class Connection {

    public String ip;
    public int port;

    /*
    public static final String LOGINSTATUS_LOGGEDIN = "LOGGEDIN";
    public static final String LOGINSTATUS_LOGGEDOUT = "LOGGEDOUT";

    private String logginstatus = LOGINSTATUS_LOGGEDOUT;
    */

    public Connection(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}