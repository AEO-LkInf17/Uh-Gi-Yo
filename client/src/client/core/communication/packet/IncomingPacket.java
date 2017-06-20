package client.core.communication.packet;

public abstract class IncomingPacket extends Packet {

    public IncomingPacket() {
    }

    public abstract void handlePacket();
}
