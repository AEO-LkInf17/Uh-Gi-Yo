package server.communication.packet.packets.outgoing;

import com.google.gson.JsonObject;
import server.Main;
import server.communication.packet.OutgoingPacket;
import server.user.User;

public class GetUserDataResult extends OutgoingPacket {
    public static final String COMMAND = "GETUSERDATARESULT";

    public static final String FAILURE_NOTEXIST = "NOTEXIST";
    public static final String FAILURE_NOTLOGGEDIN = "NOTLOGGEDIN";

    private boolean success = true;
    private String failureReason = null;

    public GetUserDataResult(User targetUser) {
        super(targetUser);
    }

    public GetUserDataResult(User targetUser, String failureReason) {
        super(targetUser);
        success = false;
        this.failureReason = failureReason;
    }

    @Override
    public JsonObject generatePacketObject() {
        JsonObject packetObject = new JsonObject();
        packetObject.addProperty("command", COMMAND);
        JsonObject result = new JsonObject();
        result.addProperty("success", success);
        if(!success) {
            JsonObject reason = new JsonObject();
            reason.addProperty("reason", failureReason);
            result.add("reason", Main.GSON.toJsonTree(reason));
        }
        packetObject.add("result", Main.GSON.toJsonTree(result));

        return packetObject;
    }
}
