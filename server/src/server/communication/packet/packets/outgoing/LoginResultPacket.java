package server.communication.packet.packets.outgoing;

import com.google.gson.JsonObject;
import server.communication.packet.IncomingPacket;
import server.communication.packet.OutgoingPacket;
import server.communication.packet.Packet;
import server.communication.packet.packets.incoming.LoginPacket;

public class LoginResultPacket extends OutgoingPacket {
    public static final String FAILURE_WRONGVER = "WRONGVER";
    public static final String FAILURE_NOTEXIST = "NOTEXIST";
    public static final String FAILURE_ISONLINE = "ISONLINE";
    public static final String FAILURE_BANNED = "BANNED";

    public static final int BANNED_PERM = 0;

    public static final String COMMAND = "LOGINRESULT";

    private boolean success = true;
    private String failureReason;
    //banLenght = BANNED_PERM = 0 -> permamently banned; banLenght equals amount of minutes left banned
    private int banLenght = -1;

    static {
        OutgoingPacket.registerPacketType(LoginResultPacket.class);
    }

    //success
    public LoginResultPacket() {

    }

    //failure
    public LoginResultPacket(String failureReason) {

    }

    //failure -> banned (banLenght = BANNED_PERM = 0 -> permamently banned; banLenght equals amount of minutes left banned)
    public LoginResultPacket(String failureReason, int banLength) {

    }

    @Override
    public JsonObject generatePacketObject() {
        JsonObject packetObject = new JsonObject();
        packetObject.addProperty("command", COMMAND);




        return packetObject;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public int getBanLenght() {
        return banLenght;
    }
}