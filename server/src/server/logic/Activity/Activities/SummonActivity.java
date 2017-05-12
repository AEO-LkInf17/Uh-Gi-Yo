package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.cards.MonsterCard;
import server.logic.exceptions.PlaceAlreadyTakenException;

public class SummonActivity extends Activity {

    private MonsterCard target;
    private int index;

    public SummonActivity(MonsterCard m,int index){
        target = m;
        this.index = index;
    }

    public MonsterCard getTarget() {
        return target;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void handleActivity() {
        try {
            target.getPlayer().getGamefield().addMonster(target,index);
        } catch (PlaceAlreadyTakenException e) {
            e.printStackTrace();
        }
        target.getPlayer().getHand().remove(target);
    }

    @Override
    public String getName() {
        return "Summon";
    }
}