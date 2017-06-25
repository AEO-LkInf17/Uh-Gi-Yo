package server;

import com.google.gson.Gson;
import server.communication.Server;
import server.sql.SQL;

public class Main {
    public static final String VERSION = "0.0-dev";
    public static final int timeout = 40; //seconds
    public static final Gson GSON = new Gson();

    private static SQL sql = new SQL();

    public static SQL getSql() {
        return sql;
    }

    public static void main(String args[]) {
        Server.getInstance().start();
    }
}