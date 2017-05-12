package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.Player;
import server.logic.cards.Card;
import server.logic.exceptions.PlaceAlreadyTakenException;

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

    public Player getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void handleActivity() {
        try {
            card.getPlayer().getGamefield().addSpell(card,index);
        } catch (PlaceAlreadyTakenException e) {
            e.printStackTrace();
        }
        card.getPlayer().getHand().removeCard(card);
    }

    @Override
    public String getName() {
        return "SetSpellOrTrapCard";
    }
}
