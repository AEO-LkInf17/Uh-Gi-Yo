package server.communication.packet.packets.incoming;

import server.communication.packet.IncomingPacket;
import server.user.User;

public class KeepAlivePacket extends IncomingPacket {
    public static final String COMMAND = "KEEPALIVE";

    public KeepAlivePacket(User sourceUser) {
        super(sourceUser);
    }

    @Override
    public void handlePacket() {
        System.out.println("packet arrived: " + COMMAND);
        sourceUser.updateKeepAlive();
    }
}
