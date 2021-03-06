package server.communication.packet.packets.incoming;

import com.google.gson.JsonObject;
import server.communication.packet.IncomingPacket;
import server.logic.Activity.Activity;
import server.user.User;

public class ChooseActivityPacket extends IncomingPacket {
    private int choice;

    public static final String COMMAND = "CHOOSEACTIVITY";

    public ChooseActivityPacket(User sourceUser, JsonObject data) {
        super(sourceUser);
        //parse packet data
        choice = data.get("choice").getAsInt();
    }

    @Override
    public void handlePacket() {
        System.out.println("packet arrived: " + COMMAND + ":: choice: " + choice);

        if(!sourceUser.isLoggedIn())
            return;

        Activity activity = Activity.getActiviyID(choice);
        if(activity.checkTimer()) {
            activity.deactivateTimer();
            activity.handleActivity();
        }
    }
}
