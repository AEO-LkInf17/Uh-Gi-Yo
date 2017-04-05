package server.logic;

import server.logic.cards.Card;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {

    private Player player;
    private ArrayList<Card> cards;


    public Hand (Player p){player = p;}

    public void setPlayer(Player player) {
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public void addCard(Card card){
        cards.add(card);
    }
    public void removeCard(Card card){
        cards.remove(card);
    }
}
