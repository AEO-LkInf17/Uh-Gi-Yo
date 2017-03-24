package server.logic;

import server.logic.cards.Card;
import server.logic.cards.MonsterCard;
import server.logic.cards.SpellCard;

import java.util.ArrayList;

public class Field extends ArrayList<Card> {
    // Referenzen
    private Player spieler;
    private ArrayList<MonsterCard> monster;
    private ArrayList<Card> zauber;
    private SpellCard feldzauber;
    // Methoden
    // getter/setter
    public ArrayList<MonsterCard> getMonster() {return monster;}
    public ArrayList<Card> getZauber() {return zauber;}
    public SpellCard getFeldzauber() {return feldzauber;}
    public Player getSpieler() { return spieler; }

    //andere
    public void addMonster(MonsterCard k){monster.add(k);}
    public void addZauber(Card k){zauber.add(k);}
    public void setFeldzauber(SpellCard k){feldzauber = k;}
    public void nimmKarteHeraus(Card a){
        //if a.getClass()==Monsterkarte {
        //    monster.remove(a);
        //}else if a.getClass()==Zauberkarte{
        //    if a.getTyp()==Feldzauber {

        //    }
    }
}
