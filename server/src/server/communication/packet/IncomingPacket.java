package server.communication.packet;

import server.user.User;

import java.util.ArrayList;
import java.util.List;

public abstract class IncomingPacket extends Packet {
    protected User sourceUser;

    public IncomingPacket(User sourceUser) {
        this.sourceUser = sourceUser;
    }

    abstract public void handlePacket();
}
