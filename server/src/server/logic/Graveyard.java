package server.logic;

import server.logic.cards.Card;

import java.util.ArrayList;

public class Graveyard {
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
