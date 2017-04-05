package server.logic;

import server.logic.cards.Card;

import java.util.ArrayList;

public class Graveyard extends ArrayList<Card> {
    private Player player;
    private ArrayList<Card> cards;

    public Graveyard (Player p){player = p;}

    public Player getPlayer() { return player; }

    public ArrayList<Card> getCards() { return cards; }

    public void addCard (Card card){
        cards.add(card);
    }
    public void removeCard(Card card){
        cards.remove(card);
    }

    public Card getTopCard(){
        return cards.get(0);
    }
}
