package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.cards.Card;
import server.logic.cards.MonsterCard;

/**SetMonsterCardActivity is there to set a monster in the hidden defence mode.
 * @author  minh_n on 05.05.2017.
 */
public abstract class SetMonsterCardActivity extends Activity {
   private MonsterCard target;
   private int index;
    private boolean hidden;

public SetMonsterCardActivity (MonsterCard m, int index){
    target = m;
    this.index = index;

}
    @Override
    public void handleActivity() {
        target.getPlayer().getGamefield().addMonster(target, index);
        target.getPlayer().getHand().removeCard(target);
    }}