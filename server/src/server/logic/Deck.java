package server.logic;

import server.logic.cards.Card;
import java.util.ArrayList;
import java.util.Collections;

/**The class Deck is there to create and save a deck, also to know his details (how many cards, which is the top card, to shuffle)
 *@author Simo ß Minh
 * @version 1.0
 */
public class Deck {
    private String description;
    // "ausstattung" speichert alle im Deck befindlichen Karten, damit
    // diese zu Beginn eines neuen Spiels zurückgesetzt werden können.
    // "configuration"(="Ausstattung"?) saves all the cards in your deck, so they can
    // be reset at the beginning of a new game
    private ArrayList<Card> configuration;
    private ArrayList<Card> cards;

    private Player player;

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setConfiguration(){
        this.configuration = cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    public void addCard(Card card){
        cards.add(card);
    }
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }

    public int getSizeCards(){
        return cards.size();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card getTopCard(){return cards.get(0);
    }
    // "removeCard" is used while pulling a card
    public void removeCard(Card card){
        cards.remove(card);
    }
}
