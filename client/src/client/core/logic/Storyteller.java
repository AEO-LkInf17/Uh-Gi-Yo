package client.core.logic;

import client.core.logic.cards.Card;
import client.core.logic.cards.FieldSpellCard;
import client.core.logic.cards.MonsterCard;

import java.util.ArrayList;
import java.util.List;

public class Storyteller {
    private ArrayList<Card> handcards;
    private FieldSpellCard fieldspellcard;
    private ArrayList<Card> graveyard;
    private MonsterCard[] monster = new MonsterCard[5];
    private Card[] spell = new Card[5];

    public ArrayList<Card> getHandcards() {return handcards;}
    public void addHandcard(Card c) {handcards.add(c);}
    public FieldSpellCard getFieldspellcard() {return fieldspellcard;}
    public void setFieldspellcard(FieldSpellCard fieldspellcard) {this.fieldspellcard = fieldspellcard;}
    public ArrayList<Card> getGraveyard() {return graveyard;}
    public void addGraveyard(Card c) {graveyard.add(c);}
    public Card getTopCard(){return graveyard.get(0);}

    public void addMonster(MonsterCard k,int index){monster[index] = k;}


}
