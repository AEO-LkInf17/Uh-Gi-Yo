package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Gamefieldside extends ArrayList<Card> {
    // Referenzen
    private Player player;
    private ArrayList<MonsterCard> monster;
    private ArrayList<Card> spell;
    private Spellcard fieldspell;
    // Methoden
    // getter/setter
    public ArrayList<MonsterCard> getMonster() {return monster;}
    public ArrayList<Card> getSpell() {return spell;}
    public Spellcard getFieldspell() {return fieldspell;}
    public Player getPlayer() { return player; }

    //andere
    public void addMonster(MonsterCard c){monster.add(c);}
    public void addSpell(Card c){
        spell.add(c);}
    public void setFieldspell(Spellcard c){
        fieldspell = c;}
    public void removeCard(Card c){
        //if c.getClass()==Monstercard {
        //    monster.remove(c);
        //}else if c.getClass()==Spellcard{
        //    if c.getTyp()==Fieldspell {

        //    }
        }
    }

