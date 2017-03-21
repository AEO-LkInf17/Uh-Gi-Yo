package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Gamefield extends ArrayList<Card> {
    // Referenzen
    private Player player;
    private ArrayList<Card> cards;

    // Methoden
    // getter/setter
    public Player getPlayer() { return player; }
    public ArrayList<Card> getCards() { return cards; }

    //andere
    public void removeCard(Card a){
        cards.remove(a);
    }
    public void addCard(Card k){
        cards.add(k);
    }
}
