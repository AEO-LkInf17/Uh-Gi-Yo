package server.communication.packets.outgoing;

import com.google.gson.JsonObject;
import server.communication.OutgoingPacket;

public class RegisterResultPacket extends OutgoingPacket {
    public static final String FAILURE_WRONGVER = "WRONGVER";
    public static final String FAILURE_ALREADYLOGGEDIN = "ALREADYLOGGEDIN";
    public static final String FAILURE_NAMENOTAVAIABLE = "NAMENOTAVAIABLE";

    public static final String COMMAND = "LOGINRESULT";

    private boolean success = true;
    private boolean failureReason;
    //success
    public RegisterResultPacket() {
        super();
    }

    //failure
    public RegisterResultPacket(String failureReason) {
        super();
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isFailureReason() {
        return failureReason;
    }

    @Override
    public JsonObject generatePacketObject() {
        return null;
    }
}
