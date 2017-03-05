package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Gamefield extends ArrayList<Card> {
    // Referenzen
    private Player player;
    private ArrayList<Card> karten;

    // Methoden
    // getter/setter
    public Player getPlayer() { return player; }
    public ArrayList<Card> getKarten() { return karten; }

    //andere
    public void nimmKarteHeraus(Card a){
        karten.remove(a);
    }
    public void addCard(Card k){
        karten.add(k);
    }
}
