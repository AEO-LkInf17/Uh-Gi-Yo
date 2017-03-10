package de.aeoinf17.project_x17;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private String description;
    // "ausstattung" speichert alle im Deck befindlichen Karten, damit
    // diese zu beginn eines neuen Spiels zurückgesetzt werden können.
    private ArrayList<Card> configuration;

    // Referenzen
    private ArrayList<Card> cards;
    private Player player;

    // Methoden
    // getter/setter
    public void setDescription(String description) {
        this.description = description;
    }
    public void setConfiguration(){
        this.configuration = cards;
    }
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    public void setPlayer(com.brashmonkey.spriter.Player player) {
        this.player = player;
    }

    public String getDescription() {
        return description;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public Player getPlayer() {
        return player;
    }

    // andere
    public int getSizeCards(){return cards.size();}
    public void addCard(Card a){
        cards.add(a);
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card giveTopCard(){return cards.get(0);
    }
    // nimmKarteHeraus wird während des Ziehens aufgerufen.
    public void removeCard(Card a){
        cards.remove(a);
    }
}
