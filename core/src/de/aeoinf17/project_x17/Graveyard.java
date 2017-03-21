package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Graveyard extends ArrayList<Card> {
    // Referenzen
    private Player player;
    private ArrayList<Card> cards;

    // getter/setter
    public Player getPlayer() { return player; }
    public ArrayList<Card> getCards() { return cards; }
    //andere
    public void removeCard(Card c){
        cards.remove(c);
    }
    public Card giveTopCard(){
        return cards.get(0);
    }
    public void addCard (Card c){ cards.add(c);
    }

}
