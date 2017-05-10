package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.Player;
import server.logic.cards.Card;

public class SetSpellOrTrapCardActivity extends Activity{
    private Player player;
    private Card card;
    private int index;

    /*
    * @param i index/place the card gets to
    **/
    public SetSpellOrTrapCardActivity (Player p,Card c,int i){
        player = p;
        card = c;
        index = i;
    }

    @Override
    public void handleActivity() {
        card.getPlayer().getGamefield().addSpell(card,index);
        card.getPlayer().getHand().removeCard(card);
    }

    @Override
    public String getName() {
        return "SetSpellOrTrapCard";
    }
}
