package server.communication.packet.packets.outgoing;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import server.Main;
import server.communication.packet.OutgoingPacket;
import server.user.User;

public class LoginResultPacket extends OutgoingPacket {
    public static final String FAILURE_WRONGVER = "WRONGVER";
    public static final String FAILURE_NOTEXIST = "NOTEXIST";
    public static final String FAILURE_ISONLINE = "ISONLINE";
    public static final String FAILURE_BANNED = "BANNED";

    public static final int BANNED_PERM = 0;
    public static final String BANNTYPE_PERM = "PERM";
    public static final String BANNTYPE_TEMP = "TEMP";

    public static final String COMMAND = "LOGINRESULT";

    private boolean success = true;
    private String failureReason = null;
    //banLength = BANNED_PERM = 0 -> permamently banned; banLength equals amount of minutes left banned
    private int banLength = -1;

    //success
    public LoginResultPacket(User targetUser) {
        super(targetUser);
    }

    //failure
    public LoginResultPacket(User targetUser, String failureReason) {
        super(targetUser);
        success = false;
        this.failureReason = failureReason;
    }

    //failure -> banned (banLength = BANNED_PERM = 0 -> permamently banned; banLength equals amount of minutes left banned)
    public LoginResultPacket(User targetUser, int banLength) {
        super(targetUser);
        failureReason = FAILURE_BANNED;
        this.banLength = banLength;
    }

    @Override
    public JsonObject generatePacketObject() {
        JsonObject packetObject = new JsonObject();
        packetObject.addProperty("command", COMMAND);
        JsonObject result = new JsonObject();
        result.addProperty("success", Boolean.toString(success));
        if(!success) {
            JsonObject reason = new JsonObject();
            reason.addProperty("reason", failureReason);
            if(failureReason.equals("FAILURE_BANNED")) {
                JsonObject banned = new JsonObject();
                if(banLength==BANNED_PERM) {
                    banned.addProperty("banntype", BANNTYPE_PERM);
                } else {
                    banned.addProperty("banntype", BANNTYPE_TEMP);
                    banned.addProperty("temp", banLength);
                }
                reason.add("banned", Main.GSON.toJsonTree(banned));
            }
            result.add("reason", Main.GSON.toJsonTree(reason));
        }
        packetObject.add("result", Main.GSON.toJsonTree(result));

        return packetObject;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public int getBanLength() {
        return banLength;
    }
}