package server.communication.packet.packets.outgoing;

import server.communication.packet.Packet;

/**
 * Created by jk0521 on 10.03.2017.
 */
public class RegisterResultPacket extends Packet {
    public static final String FAILURE_WRONGVER = "WRONGVER";
    public static final String FAILURE_ALREADYLOGGEDIN = "ALREADYLOGGEDIN";
    public static final String FAILURE_NAMENOTAVAIABLE = "NAMENOTAVAIABLE";

    private boolean success = true;

    //success
    public RegisterResultPacket() {

    }

    //failure
    public RegisterResultPacket(String failureReason) {

    }
}
