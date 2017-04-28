package client.core.logic;

import client.core.logic.cards.Card;
import client.core.logic.cards.FieldSpellCard;

import java.util.ArrayList;
import java.util.List;

public class Storyteller {
    private List<Card> fieldcards;
    private ArrayList<Card> handcards;
    private FieldSpellCard fieldspellcard;
    private ArrayList<Card> graveyard;

    public List<Card> getFieldcards() {return fieldcards;}
    public void setFieldcard(Card c,int i) {fieldcards.add(i,c);}
    public ArrayList<Card> getHandcards() {return handcards;}
    public void addHandcard(Card c) {handcards.add(c);}
    public FieldSpellCard getFieldspellcard() {return fieldspellcard;}
    public void setFieldspellcard(FieldSpellCard fieldspellcard) {this.fieldspellcard = fieldspellcard;}
    public ArrayList<Card> getGaveyard() {return graveyard;}
    public void addGaveyard(Card c) {graveyard.add(c);}
    public Card getTopCard(){return graveyard.get(0);}


}
