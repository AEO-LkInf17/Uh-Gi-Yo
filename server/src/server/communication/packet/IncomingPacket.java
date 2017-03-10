package server.communication.packet;

/**
 * Created by jk0521 on 10.03.2017.
 */
public abstract class IncomingPacket extends Packet {
    public abstract void handlePacket();
}
