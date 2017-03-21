package server.communication.packet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk0521 on 10.03.2017.
 */
public abstract class IncomingPacket extends Packet {
    private static List<Class<?>> packetTypes = new ArrayList<Class<?>>();

    private static void registerPacketType(Class<?> packetType) {
        if(!packetTypes.contains(packetType))
            packetTypes.add(packetType);
    }

    public abstract void handlePacket();

    protected IncomingPacket() {
        registerPacketType(this.getClass());
    }
}
