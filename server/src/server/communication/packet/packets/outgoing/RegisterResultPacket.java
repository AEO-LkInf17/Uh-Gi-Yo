package server.communication.packet.packets.outgoing;

import com.google.gson.JsonObject;
import server.Main;
import server.communication.packet.OutgoingPacket;
import server.communication.packet.Packet;
import server.user.User;

public class RegisterResultPacket extends OutgoingPacket {
    public static final String FAILURE_WRONGVER = "WRONGVER";
    public static final String FAILURE_ALREADYLOGGEDIN = "ALREADYLOGGEDIN";
    public static final String FAILURE_NAMENOTAVAIABLE = "NAMENOTAVAIABLE";

    public static final String COMMAND = "LOGINRESULT";

    private boolean success = true;
    private String failureReason;

    //success
    public RegisterResultPacket(User targetUser) {
        super(targetUser);
    }

    //failure
    public RegisterResultPacket(User targetUser, String failureReason) {
        super(targetUser);
        success = false;
        this.failureReason = failureReason;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFailureReason() {
        return failureReason;
    }

    @Override
    public JsonObject generatePacketObject() {
        JsonObject packetObject = new JsonObject();
        packetObject.addProperty("command", COMMAND);
        JsonObject result = new JsonObject();
        result.addProperty("success", success);
        if(!success) {
            result.addProperty("reason", failureReason);
        }
        packetObject.add("result", Main.GSON.toJsonTree(result));
        return packetObject;
    }
}