package server.logic;

import server.logic.cards.*;
import server.logic.cards.MonsterCard;

import java.util.ArrayList;

public class Field extends ArrayList<Card> {

    private Player player;
    private ArrayList<MonsterCard> monster;
    private ArrayList<Card> spell;
    private SpellCard fieldspell;

    public Field (Player p){player = p;}

    public void addMonster(MonsterCard k){monster.add(k);}
    public ArrayList<MonsterCard> getMonster() {return monster;}
    public void addSpell(Card card){spell.add(card);}
    public ArrayList<Card> getSpell() {return spell;}
    public void setFieldspell(SpellCard card){fieldspell = card;}
    public SpellCard getFieldspell() {return fieldspell;}
    public Player getPlayer() { return player; }

    public void removeCard(Card card){
        if (card.getClass()==MonsterCard.class) {
            monster.remove(card);
        }else if (card.getClass()==SpellCard.class) {
            spell.remove(card);
        }else if (card.getClass()==FieldSpellCard.class){
             fieldspell = null;
        }
    }
}
