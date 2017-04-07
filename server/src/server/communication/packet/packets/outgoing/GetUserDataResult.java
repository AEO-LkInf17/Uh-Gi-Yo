package server.communication.packet.packets.outgoing;

import com.google.gson.JsonObject;
import server.communication.packet.OutgoingPacket;
import server.user.User;
//TODO Implement!
public class GetUserDataResult extends OutgoingPacket {
    public GetUserDataResult(User targetUser) {
        super(targetUser);
    }

    @Override
    public JsonObject generatePacketObject() {
        return null;
    }
}
