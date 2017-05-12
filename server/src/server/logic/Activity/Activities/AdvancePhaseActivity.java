package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.Player;

public class AdvancePhaseActivity extends Activity{
    private Player player;

    public AdvancePhaseActivity (Player p){
        player = p;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void handleActivity() {
        player.getGame().nextPhase();
        player.getGame().sendPossibleActivities();
    }

    @Override
    public String getName() {
        return "AdvancePhase";
    }
}


