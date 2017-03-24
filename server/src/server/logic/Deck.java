package server.logic;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private String description;
    // "ausstattung" speichert alle im Deck befindlichen Karten, damit
    // diese zu beginn eines neuen Spiels zurückgesetzt werden können.
    // "configuration"(="Ausstattung"?) saves all the cards in your deck, so they can
    // be reset at the beginning of a new game
       private ArrayList<Card> configuration;

    // references
    private ArrayList<Card> cards;
    private Player player;

    // methods
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
    public void setPlayer(Player player) {this.player = player;}

    public String getDescription() {
        return description;
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public Player getPlayer() {
        return player;
    }

    // other methods
    public int getSizeCards(){return cards.size();}
    public void addCard(Card a){
        cards.add(a);
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card giveTopCard(){return cards.get(0);
    }
    // "removeCard" is used while pulling a card
    public void removeCard(Card a){
        cards.remove(a);
    }
    //comment translation by Niels
}
