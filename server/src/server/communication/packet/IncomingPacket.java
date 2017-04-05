package server.communication.packet;

import server.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk0521 on 10.03.2017.
 */
public abstract class IncomingPacket extends Packet {
    protected User sourceUser;

    public IncomingPacket(User sourceUser) {
        this.sourceUser = sourceUser;
    }

    abstract public void handlePacket();
}
