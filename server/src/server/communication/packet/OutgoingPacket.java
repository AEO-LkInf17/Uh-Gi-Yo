package server.communication.packet;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk0521 on 10.03.2017.
 */
public abstract class OutgoingPacket extends Packet {
    abstract public JsonObject generatePacketObject();

    protected void sendJSONObject(JsonObject packet) {

    }
}