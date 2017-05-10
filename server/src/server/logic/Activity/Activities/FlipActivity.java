package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.Player;
import server.logic.cards.MonsterCard;

public class FlipActivity extends Activity {

    private MonsterCard monstercard;
    private Player player;


    public FlipActivity (MonsterCard m, Player p)
    {
     monstercard = m;
     player = p;
    }

    @Override
    public void handleActivity() {
      monstercard.reveal();



    }

    @Override
    public String getName() {
        return "Flip";
    }
}
