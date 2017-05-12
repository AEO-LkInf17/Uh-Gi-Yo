package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.Player;
import server.logic.cards.MonsterCard;

public class PositionChangeActivity extends Activity{
    private MonsterCard monster;
    private Player player;

    public PositionChangeActivity (MonsterCard m,Player p){
        monster = m;
        player = p;
    }

    public MonsterCard getMonster() {
        return monster;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void handleActivity() {
        monster.changemode();
        player.getGame().sendPossibleActivities();
    }

    @Override
    public String getName() {
        return "PositionChange";
    }
}
