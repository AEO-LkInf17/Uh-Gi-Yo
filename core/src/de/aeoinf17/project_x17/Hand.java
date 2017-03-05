package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {
    // Referenz
    private Player player;
    private ArrayList<Card> cards;

    // Methoden
    //getter/setter
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
    //andere
    public void addCard(Card a){
        cards.add(a);
    }
    public void removeCard(Card a){
        cards.remove(a);
    }
}
