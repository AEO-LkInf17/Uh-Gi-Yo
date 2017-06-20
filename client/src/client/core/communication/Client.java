package client.core.communication;

import client.core.communication.exceptions.ClientAlreadyConnectedException;
import client.core.communication.exceptions.ClientHasNoConnection;
import client.core.communication.exceptions.ServerNotReachableException;
import client.core.communication.packet.OutgoingPacket;
import client.core.communication.packet.outgoing.LoginPacket;
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

    public void run() {
        if (isConnected()) {
            new Thread(() -> {
                while (isConnected()) {
                    try {
                        JsonObject result = gson.fromJson(in.readLine(), JsonObject.class);
                        if (result == null) disconnect();
                        String command = result.get("command").getAsString();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void disconnect() {
        try {
            currentConnection.close();
            currentConnection = null;
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
}
