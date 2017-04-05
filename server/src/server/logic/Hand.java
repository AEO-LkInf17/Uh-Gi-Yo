package server.logic;

import server.logic.cards.Card;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {

    private Player player;
    private ArrayList<Card> cards;


    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    public Player getPlayer() {
        return player;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card a){
        cards.add(a);
    }
    public void removeCard(Card a){
        cards.remove(a);
    }
}
