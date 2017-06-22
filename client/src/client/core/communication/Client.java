package client.core.communication;

import client.core.communication.exceptions.ClientAlreadyConnectedException;
import client.core.communication.exceptions.ServerNotReachableException;
import client.core.communication.packet.IncomingPacket;
import client.core.communication.packet.OutgoingPacket;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static Client instance;

    private Socket currentConnection;

    private BufferedReader in;
    private PrintWriter out;

    private Gson gson;

    private Client() {
        super();
    }

    public static Client getInstance() {
        if (instance == null) instance = new Client();
        return instance;
    }

    public void initialize() {
        this.currentConnection = null;
        this.in = null;
        this.out = null;
        this.gson = new Gson();
    }

    public boolean isConnected() {
        if (currentConnection != null) return true;
        return false;
    }

    public void connect(Connection server) throws ClientAlreadyConnectedException, ServerNotReachableException {
        if (isConnected()) throw new ClientAlreadyConnectedException();
        try {
            currentConnection = new Socket(server.ip, server.port);
            in = new BufferedReader(new InputStreamReader(currentConnection.getInputStream()));
            out = new PrintWriter(currentConnection.getOutputStream());
        } catch (IOException e) {
            throw new ServerNotReachableException();
        }
    }

    public void start() {
        if (isConnected()) {
            new Thread(() -> {
                while (isConnected()) {
                    try {
                        JsonObject result = gson.fromJson(in.readLine(), JsonObject.class);
                        if (result == null) disconnect();
                        String command = result.get("command").getAsString();
                        IncomingPacket packet = null;
                        /*
                        switch (command) {
                            case LoginPacket.COMMAND:
                                packet = new LoginPacket(user, result.getAsJsonObject("data"));
                                break;
                            case RegisterPacket.COMMAND:
                                packet = new RegisterPacket(user, result.getAsJsonObject("data"));
                                break;
                            case KeepAlivePacket.COMMAND:
                                packet = new KeepAlivePacket(user);
                                break;
                            case GetUserDataPacket.COMMAND:
                                packet = new GetUserDataPacket(user, result.getAsJsonObject("data"));
                                break;
                            case ChooseActivityPacket.COMMAND:
                                packet = new ChooseActivityPacket(user, result.getAsJsonObject("data"));
                            default:
                                break;
                        }*/

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void disconnect() {
        try {
            currentConnection = null;
            currentConnection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPacket(OutgoingPacket packet) {
        if (isConnected()) {
            out.println(packet.generatePacketObject().toString());
        }
    }

    public Gson getGson() {
        return gson;
    }

    public static void main(String[] args) {
        Connection conn = new Connection("localhost", 42042);
        try {
            Client.getInstance().initialize();
            Client.getInstance().connect(conn);
        } catch (ClientAlreadyConnectedException e) {
            e.printStackTrace();
        } catch (ServerNotReachableException e) {
            e.printStackTrace();
        }
    }
}
