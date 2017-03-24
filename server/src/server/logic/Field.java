package server.logic;

import server.logic.cards.MonsterCard;
import server.logic.cards.Spellcard;

import java.util.ArrayList;

public class field extends ArrayList<Card> {

    private Player player;
    private ArrayList<MonsterCard> monster;
    private ArrayList<Card> spell;
    private Spellcard fieldspell;


    public ArrayList<MonsterCard> getMonster() {return monster;}
    public ArrayList<Card> getSpell() {return spell;}
    public Spellcard getFieldspell() {return fieldspell;}
    public Player getSpieler() { return player; }

    //andere
    public void addMonster(MonsterCard k){monster.add(k);}
    public void addZauber(Card k){spell.add(k);}
    public void setFeldzauber(Spellcard k){fieldspell = k;}
    public void nimmKarteHeraus(Card a){
        //if a.getClass()==MonsterCard {
        //    monster.remove(a);
        //}else if a.getClass()==Spellcard{
        //    if a.getTyp()==fieldspell {

        //    }
    }
}
