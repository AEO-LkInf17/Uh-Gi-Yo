package server.communication.packet.packets.incoming;

import com.google.gson.JsonObject;
import server.Main;
import server.communication.packet.IncomingPacket;
import server.communication.packet.packets.outgoing.LoginResultPacket;
import server.user.User;
import server.user.exceptions.ClientAlreadyLoggedinException;
import server.user.exceptions.UserBannedException;
import server.user.exceptions.UserIsOnlineException;
import server.user.exceptions.UserNotExistException;

public class LoginPacket extends IncomingPacket {
    private String username;
    private String version;

    public static final String COMMAND = "LOGIN";

    public LoginPacket(User sourceUser, JsonObject data) {
        super(sourceUser);
        //parse packet data
        username = data.get("username").getAsString();
        version = data.get("version").getAsString();
    }

    @Override
    public void handlePacket() {
        System.out.println("packet arrived: " + COMMAND + ":: username: " + username + ", version:" + version);
        if(!version.equals(Main.VERSION)) {
            new LoginResultPacket(sourceUser, LoginResultPacket.FAILURE_WRONGVER).sendPacket();
            return;
        }
        try {
            sourceUser.login(username);
        } catch (ClientAlreadyLoggedinException e) {
            new LoginResultPacket(sourceUser, LoginResultPacket.FAILURE_ALREADYLOGGEDIN).sendPacket();
        } catch (UserNotExistException e) {
            new LoginResultPacket(sourceUser, LoginResultPacket.FAILURE_NOTEXIST).sendPacket();
        } catch (UserIsOnlineException e) {
            new LoginResultPacket(sourceUser, LoginResultPacket.FAILURE_ISONLINE).sendPacket();
        } catch (UserBannedException e) {
            new LoginResultPacket(sourceUser, e.getBanLength()).sendPacket();
        }
    }
}
