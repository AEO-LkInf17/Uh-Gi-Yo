package client.core.communication.packet;

import com.google.gson.JsonObject;

public abstract class OutgoingPacket extends Packet {

    public OutgoingPacket() {
    }

    public abstract JsonObject generatePacketObject();
}
