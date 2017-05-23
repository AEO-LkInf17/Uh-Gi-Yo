package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.Player;

public class DrawCardActivity extends Activity{
    private Player player;

    public DrawCardActivity (Player p){
        player = p;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void handleActivity() {
        player.drawCard();
        player.getGame().nextPhase();
        player.getGame().sendPossibleActivities(player);
    }

    @Override
    public String getName() {
        return "DrawCard";
    }
}
