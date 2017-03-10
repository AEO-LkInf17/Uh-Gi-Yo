package server.communication.packet;

import com.google.gson.JsonObject;

/**
 * Created by jk0521 on 10.03.2017.
 */
public abstract class OutgoingPacket extends Packet {
    protected void sendJSONObject(JsonObject packet) {

    }
}
