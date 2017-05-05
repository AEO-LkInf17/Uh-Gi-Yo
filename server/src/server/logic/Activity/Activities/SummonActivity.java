package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.cards.MonsterCard;

public class SummonActivity extends Activity {

    private MonsterCard target;

    public SummonActivity (MonsterCard m){target = m;}

    @Override
    public void handleActivity() {
        target.getPlayer().getGamefield().add(target);
        target.getPlayer().getHand().remove(target);
    }
}
