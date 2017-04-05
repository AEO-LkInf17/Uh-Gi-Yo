package server.communication.packet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk0521 on 10.03.2017.
 */
public abstract class IncomingPacket extends Packet {
    abstract public void handlePacket();
}
