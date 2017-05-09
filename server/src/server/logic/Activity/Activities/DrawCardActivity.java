package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.Player;

/**
 * Created by minh_n on 05.05.2017.
 */
public class DrawCardActivity extends Activity{
    private Player player;

    public DrawCardActivity (Player p){
        player = p;
    }

    @Override
    public void handleActivity() {
        player.drawCard();
    }
}
