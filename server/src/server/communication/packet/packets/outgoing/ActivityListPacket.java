package server.communication.packet.packets.outgoing;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import server.Main;
import server.communication.packet.OutgoingPacket;
import server.logic.Activity.Activities.*;
import server.logic.Activity.Activity;
import server.user.User;
import server.util.Timer;

public class ActivityListPacket extends OutgoingPacket {
    public static final String COMMAND = "ACTIVITYLIST";

    private int time;
    private Activity[] activities;

    public ActivityListPacket(User targetUser, int time, Activity[] activities) {
        super(targetUser);
        this.time = time-1; //latency? ._.
        this.activities = activities;

        Timer timer = new Timer(time);
        for(Activity activity : activities) {
            activity.setTimer(timer);
        }
    }



    @Override
    public JsonObject generatePacketObject() {
        JsonObject packetObject = new JsonObject();
        packetObject.addProperty("command", COMMAND);
        JsonObject data = new JsonObject();
        data.addProperty("time", time);
        JsonArray activities = new JsonArray();
        for(Activity activity : this.activities) {
            JsonObject activityElement = new JsonObject();
            activityElement.addProperty("type", activity.getName());
            activityElement.addProperty("id", activity.getID());
            JsonObject parameter = new JsonObject();
            if(activity instanceof ActivateMonsterAffectActivity) { //TODO: add all parameter ):

            } else if(activity instanceof ActivateSpellActivity) {

            } else if(activity instanceof ActivateTrapActivity) {

            } else if(activity instanceof AdvancePhaseActivity) {

            } else if(activity instanceof AttackActivity) {
                parameter.addProperty("user", 623);
                parameter.addProperty("target", 243);
            } else if(activity instanceof DrawCardActivity) {

            } else if(activity instanceof FlipActivity) {

            } else if(activity instanceof PositionChangeActivity) {

            } else if(activity instanceof SetMonsterCardActivity) {

            } else if(activity instanceof SetSpellOrTrapCardActivity) {

            } else if(activity instanceof SpecialSummonActivity) {

            } else if(activity instanceof SummonActivity) {

            }
            activityElement.add("parameter", Main.GSON.toJsonTree(parameter));
            activities.add(activityElement);
        }


        data.add("list", Main.GSON.toJsonTree(activities));
        packetObject.add("data", Main.GSON.toJsonTree(data));
        return packetObject;
    }
}
