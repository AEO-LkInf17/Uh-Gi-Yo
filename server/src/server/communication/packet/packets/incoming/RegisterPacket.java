package server.communication.packet.packets.incoming;

import com.google.gson.JsonObject;
import server.Main;
import server.communication.packet.IncomingPacket;
import server.communication.packet.packets.outgoing.LoginResultPacket;
import server.communication.packet.packets.outgoing.RegisterResultPacket;
import server.user.User;
import server.user.exceptions.ClientAlreadyLoggedinException;
import server.user.exceptions.NameNotAvailableException;

public class RegisterPacket extends IncomingPacket {
    private String username;
    private String version;

    public static final String COMMAND = "REGISTER";

    public RegisterPacket(User sourceUser, JsonObject data) {
        super(sourceUser);
        //parse packet data
        username = data.get("username").getAsString();
        version = data.get("version").getAsString();
    }

    @Override
    public void handlePacket() {
        System.out.println("packet arrived: " + COMMAND + ":: username: " + username + ", version:" + version);
        if(!version.equals(Main.VERSION)) {
            new RegisterResultPacket(sourceUser, RegisterResultPacket.FAILURE_WRONGVER).sendPacket();
            return;
        }
        try {
            sourceUser.register(username); //TODO
        } catch (ClientAlreadyLoggedinException e) {
            e.printStackTrace();
        } catch (NameNotAvailableException e) {
            e.printStackTrace();
        }
    }
}
