package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.cards.MonsterCard;

public class SummonActivity extends Activity {

    private MonsterCard target;
    private int index;

    public SummonActivity(MonsterCard m,int index){
        target = m;
        this.index = index;
    }

    @Override
    public void handleActivity() {
        target.getPlayer().getGamefield().addMonster(target,index);
        target.getPlayer().getHand().remove(target);
    }

    @Override
    public String getName() {
        return "Summon";
    }
}