package client.core.logic;

import client.core.logic.cards.Card;
import client.core.logic.cards.FieldSpellCard;
import client.core.logic.cards.MonsterCard;

import java.util.ArrayList;
import java.util.List;

public class Storyteller {
    //Saves attributes on the client
    private ArrayList<Card> handcards;
    private FieldSpellCard fieldspellcard;
    private ArrayList<Card> graveyard;
    private MonsterCard[] monster = new MonsterCard[5];
    // Goes for trap cards and spell cards
    private Card[] spell = new Card[5];

    // shows the cards in ones hand to the player
    public ArrayList<Card> getHandcards() {return handcards;}
    // adds a card to the player's hand
    public void addHandcard(Card c) {handcards.add(c);}
    // allows the player to see the fieldspellcard currently placed on the field. If there is none on the field this method is nulled
    public FieldSpellCard getFieldspellcard() {return fieldspellcard;}
    // places a fieldspell into the fieldspellcard slot on the field
    public void setFieldspellcard(FieldSpellCard fieldspellcard) {this.fieldspellcard = fieldspellcard;}
    // allows the player to see the cards in the graveyard
    public ArrayList<Card> getGraveyard() {return graveyard;}
    // adds a card to the graveyard through the card being destroyed or discarded
    public void addGraveyard(Card c) {graveyard.add(c);}
    // shows the current top card/most recent card sent to/in the graveyard
    public Card getTopCard(){return graveyard.get(0);}

    // Adds a monster to the game field, also assigns the monster to a numbered spot
    public void addMonster(MonsterCard k,int index){monster[index] = k;}
    // allows player to see monsters on the field
    public MonsterCard[] getMonster() {return monster;}
    // adds a spell or trap card to the game field on a numbered spot
    public void addSpell(Card card,int index){spell[index] = card;}
    // allows the player to see the spells or traps
    public Card[] getSpell() {return spell;}
    // test

}
