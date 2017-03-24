package server.communication;

import java.util.ArrayList;
import java.util.List;

public abstract class IncomingPacket extends Packet {
    private static List<Class<?>> packetTypes = new ArrayList<>();

    private static void registerPacketType(Class<?> packetType) {
        if(!packetTypes.contains(packetType))
            packetTypes.add(packetType);
    }

    public abstract void handlePacket();

    protected IncomingPacket() {
        registerPacketType(this.getClass());
    }
}
