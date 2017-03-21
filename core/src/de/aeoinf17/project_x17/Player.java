package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Player {
    private String name;
    private String rank;
    private int lifepoints;
    private int points;
    // Referenzen
    private ArrayList<Deck> decks;
    private Deck momentaryDeck;
    private Hand hand;
    private Gamefield gamefield;
    private Graveyard graveyard;

    // Methoden
    // getter / setter
    public void setName(String name) {
        this.name = name;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public void setLifepoints(int lifepoints) {
        this.lifepoints = lifepoints;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }
    public void setMomentaryDeck(Deck momentaryDeck) {
        this.momentaryDeck = momentaryDeck;
    }
    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public void setGamefield(Gamefield gamefield) {
        this.gamefield = gamefield;
    }
    public void setGraveyard(Graveyard graveyard) {
        this.graveyard = graveyard;
    }

    public String getName() {
        return name;
    }
    public String getRank() {
        return rank;
    }
    public int getLifepoints() {
        return lifepoints;
    }
    public int getPoints() { return points; }
    public ArrayList<Deck> getDecks() {
        return decks;
    }
    public Deck getMomentaryDeck() {
        return momentaryDeck;
    }
    public Hand getHand() {
        return hand;
    }
    public Gamefield getGamefield() {
        return gamefield;
    }
    public Graveyard getGraveyard() {
        return graveyard;
    }

    // andere

    public void drawCard(){
        Card k= momentaryDeck.giveTopCard();
        hand.addCard(k);
        momentaryDeck.removeCard(k);
    }
    public void set(MonsterCard k){
        k.reveal();
        gamefield.addCard(k);
        hand.removeCard(k);
    }
    public void place(MonsterCard k){
        k.conceal();
        gamefield.addCard(k);
        hand.removeCard(k);
    }
    public void changeposition(MonsterCard k){
        k.changemode();
    }
    public void flip(MonsterCard k){
        k.reveal();
    }

    public void destroy(Card k){
        graveyard.add(k);
        gamefield.remove(k);
    }
    public void revive(Card k){
        gamefield.add(k);
        graveyard.remove(k);
    }
}
