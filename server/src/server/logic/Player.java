package server.logic;

import server.logic.cards.Card;
import server.logic.cards.MonsterCard;

import java.util.ArrayList;

class Player {
    private String name;
    private String rank;
    private int lifepoints;
    private int points;

    private ArrayList<Deck> decks;
    private Deck momentaryDeck;
    private Hand hand;
    private Field gamefield;
    private Graveyard graveyard;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getRank() {
        return rank;
    }

    public void setLifepoints(int lifepoints) {
        this.lifepoints = lifepoints;
    }
    public int getLifepoints() {
        return lifepoints;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public int getPoints() { return points; }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }
    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public void setMomentaryDeck(Deck momentaryDeck) {
        this.momentaryDeck = momentaryDeck;
    }
    public Deck getMomentaryDeck() {
        return momentaryDeck;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public Hand getHand() {
        return hand;
    }

    public void setGamefield(Field gamefield) {
        this.gamefield = gamefield;
    }
    public Field getGamefield() {
        return gamefield;
    }

    public void setGraveyard(Graveyard graveyard) {
        this.graveyard = graveyard;
    }
    public Graveyard getGraveyard() {
        return graveyard;
    }

    public void drawCard(){
        Card card = momentaryDeck.getTopCard();
        hand.addCard(card);
        momentaryDeck.removeCard(card);
    }
    public void set(MonsterCard card){
        card.reveal();
        gamefield.addMonster(card);
        hand.removeCard(card);
    }
    public void place(MonsterCard card){
        card.conceal();
        gamefield.addMonster(card);
        hand.removeCard(card);
    }
    public void changeposition(MonsterCard card){
        card.changemode();
    }
    public void flip(MonsterCard card){
        card.reveal();
    }

    public void destroy(Card card){
        graveyard.add(card);
        gamefield.remove(card);
    }
    public void revive(Card card){
        gamefield.add(card);
        graveyard.remove(card);
    }
}
