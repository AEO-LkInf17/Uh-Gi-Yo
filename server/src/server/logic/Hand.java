package server.logic;

import server.logic.cards.Card;

import java.util.ArrayList;

class Hand extends ArrayList<Card> {

    private Player player;
    private ArrayList<Card> cards;


    public Hand (Player p){player = p;player.setHand(this);}


    public void setPlayer(Player player) {
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }

    /**This method is there to set a ArrayList for Cards
     *
     * @param cards cards
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**This method is there to get the cards fform the ArrayList
     *
     * @return return cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
    public void addCard(Card card){
        cards.add(card);
    }
    public void removeCard(Card card){
        cards.remove(card);
    }
}
