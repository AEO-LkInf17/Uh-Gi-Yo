package server.communication.packet.packets.outgoing;

import com.google.gson.JsonObject;
import server.communication.packet.OutgoingPacket;
import server.communication.packet.Packet;

/**
 * Created by jk0521 on 10.03.2017.
 */
public class RegisterResultPacket extends OutgoingPacket {
    public static final String FAILURE_WRONGVER = "WRONGVER";
    public static final String FAILURE_ALREADYLOGGEDIN = "ALREADYLOGGEDIN";
    public static final String FAILURE_NAMENOTAVAIABLE = "NAMENOTAVAIABLE";

    public static final String COMMAND = "LOGINRESULT";

    private boolean success = true;
    private boolean failureReason;

    static {
        OutgoingPacket.registerPacketType(RegisterResultPacket.class);
    }

    //success
    public RegisterResultPacket() {

    }

    //failure
    public RegisterResultPacket(String failureReason) {

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
