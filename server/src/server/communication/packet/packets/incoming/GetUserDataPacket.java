package server.communication.packet.packets.incoming;

import com.google.gson.JsonObject;
import server.Main;
import server.communication.packet.IncomingPacket;
import server.communication.packet.packets.outgoing.GetUserDataResult;
import server.user.User;

public class GetUserDataPacket extends IncomingPacket {
    private String username;

    public static final String COMMAND = "GETUSERDATA";

    public GetUserDataPacket(User sourceUser, JsonObject data) {
        super(sourceUser);
        //parse packet data
        this.username = data.get("username").getAsString();
    }

    @Override
    public void handlePacket() {
        System.out.println("packet arrived: " + COMMAND + ":: username: " + username);

        if(!sourceUser.isLoggedIn()) {
            new GetUserDataResult(sourceUser, GetUserDataResult.FAILURE_NOTLOGGEDIN).sendPacket();
            return;
        }

        if(!Main.getSql().userExists(username)) {
            new GetUserDataResult(sourceUser, GetUserDataResult.FAILURE_NOTEXIST).sendPacket();
            return;
        }

        new GetUserDataResult(sourceUser).sendPacket();
    }
}
