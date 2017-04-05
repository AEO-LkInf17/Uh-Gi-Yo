package server.communication.packet;

import com.google.gson.JsonObject;
import server.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk0521 on 10.03.2017.
 */
public abstract class OutgoingPacket extends Packet {
    protected User targetUser;

    public OutgoingPacket(User targetUser) {
        this.targetUser = targetUser;
    }

    abstract public JsonObject generatePacketObject();

    protected void sendJSONObject() {
        //TODO sent packet generated by #generatedPacketObject() to targetUser via an upcoming method in User
    }
}