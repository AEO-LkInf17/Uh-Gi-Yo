package server.communication.packet;

import com.google.gson.JsonObject;
import server.user.User;

import java.util.ArrayList;
import java.util.List;

public abstract class OutgoingPacket extends Packet {
    protected User targetUser;

    public OutgoingPacket(User targetUser) {
        this.targetUser = targetUser;
    }

    abstract public JsonObject generatePacketObject();

    public void sendPacket() {
        targetUser.sendPacket(this);
    }
}