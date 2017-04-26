package server;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import server.communication.Server;
import server.communication.packet.IncomingPacket;
import server.communication.packet.packets.incoming.LoginPacket;
import server.communication.packet.packets.incoming.RegisterPacket;
import server.sql.SQL;
import server.user.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Main {
    public static final String VERSION = "0.0-dev";
    public static final Gson GSON = new Gson();

    private static Server server = new Server();
    private static SQL sql = new SQL();

    public static Server getServer() {
        return server;
    }
    public static SQL getSql() {
        return sql;
    }

    public static void main(String args[]) {

    }
}