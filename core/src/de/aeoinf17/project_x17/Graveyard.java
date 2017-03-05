package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Graveyard extends ArrayList<Card> {
    // Referenzen
    private Player player;
    private ArrayList<Card> karten;

    // getter/setter
    public Player getPlayer() { return player; }
    public ArrayList<Card> getKarten() { return karten; }
    //andere
    public void nimmKarteHeraus(Card a){
        karten.remove(a);
    }
    public Card gibObersteKarte(){
        return karten.get(0);
    }
    public void fuegeKartehinzu (Card k){
        karten.add(k);
    }

}
