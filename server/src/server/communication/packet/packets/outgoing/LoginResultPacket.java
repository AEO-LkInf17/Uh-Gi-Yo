package server.communication.packet.packets.outgoing;

import server.communication.packet.Packet;

/**
 * Created by jk0521 on 10.03.2017.
 */
public class LoginResultPacket extends Packet {
    public static final String FAILURE_WRONGVER = "WRONGVER";
    public static final String FAILURE_NOTEXIST = "NOTEXIST";
    public static final String FAILURE_ISONLINE = "ISONLINE";
    public static final String FAILURE_BANNED = "BANNED";

    public static final int BANNED_PERM = 0;

    private boolean success = true;

    //success
    public LoginResultPacket() {

    }

    //failure
    public LoginResultPacket(String failureReason) {

    }

    //failure -> banned (banLenght = BANNED_PERM = 0 -> permamently banned; banLenght equals amount of minutes left banned)
    public LoginResultPacket(String failureReason, int banLength) {

    }
}
