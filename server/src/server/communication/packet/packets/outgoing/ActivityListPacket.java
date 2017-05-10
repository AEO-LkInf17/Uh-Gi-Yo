package server.communication.packet.packets.outgoing;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import server.Main;
import server.communication.packet.OutgoingPacket;
import server.logic.Activity.Activities.*;
import server.logic.Activity.Activity;
import server.user.User;

public class ActivityListPacket extends OutgoingPacket {
    public static final String COMMAND = "ACTIVITYLIST";

    private int time;
    private Activity[] activities;

    //TODO add timer
    public ActivityListPacket(User targetUser, int time, Activity[] activities) {
        super(targetUser);
        this.time = time;
        this.activities = activities;
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
            if(activity instanceof ActivateMonsterAffectActivity) {

            } else if(activity instanceof ActivateSpellActivity) {

            } else if(activity instanceof ActivateTrapActivity) {

            } else if(activity instanceof AttackActivity) {

            } else if(activity instanceof DrawCardActivity) {

            } else if(activity instanceof FlipActivity) {

            } else if(activity instanceof PositionChangeActivity) {

            } else if(activity instanceof SetMonsterCardActivity) {

            } else if(activity instanceof SetSpellOrTrapCardActivity) {

            } else if(activity instanceof SpecialSummonActivity) {

            } else if(activity instanceof SummonActivity) {
                
            }
        }


        data.add("list", Main.GSON.toJsonTree(activities));
        packetObject.add("data", Main.GSON.toJsonTree(data));
        return packetObject;
    }
}
