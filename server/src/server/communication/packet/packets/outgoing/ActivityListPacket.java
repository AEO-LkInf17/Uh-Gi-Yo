package server.communication.packet.packets.outgoing;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import server.Main;
import server.communication.packet.OutgoingPacket;
import server.user.User;

public class ActivityListPacket extends OutgoingPacket {
    public static final String COMMAND = "ACTIVITYLIST";

    private int time;

    //TODO create constructor with a list of activitys as a parameter
    public ActivityListPacket(User targetUser, int time) {
        super(targetUser);
        this.time = time;
    }



    @Override
    public JsonObject generatePacketObject() {
        JsonObject packetObject = new JsonObject();
        packetObject.addProperty("command", COMMAND);
        JsonObject data = new JsonObject();
        data.addProperty("time", time);
        JsonArray activitys = new JsonArray();
        //TODO add all the activitys to the list
        data.add("list", Main.GSON.toJsonTree(activitys));
        packetObject.add("data", Main.GSON.toJsonTree(data));
        return packetObject;
    }
}
