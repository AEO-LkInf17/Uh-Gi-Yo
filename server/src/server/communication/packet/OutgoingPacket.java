package server.communication.packet;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk0521 on 10.03.2017.
 */
public abstract class OutgoingPacket extends Packet {
    private static List<Class<?>> packetTypes = new ArrayList<Class<?>>();

    private static void registerPacketType(Class<?> packetType) {
        if(!packetTypes.contains(packetType))
            packetTypes.add(packetType);
    }

    public abstract JsonObject generatePacketObject();

    protected OutgoingPacket() {
        registerPacketType(this.getClass());
    }

    protected void sendJSONObject(JsonObject packet) {

    }
}
