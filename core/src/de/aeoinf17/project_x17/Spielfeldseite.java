package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Spielfeldseite extends ArrayList<Card> {
    // Referenzen
    private Player spieler;
    private ArrayList<MonsterCard> monster;
    private ArrayList<Card> zauber;
    private Zauberkarte feldzauber;
    // Methoden
    // getter/setter
    public ArrayList<MonsterCard> getMonster() {return monster;}
    public ArrayList<Card> getZauber() {return zauber;}
    public Zauberkarte getFeldzauber() {return feldzauber;}
    public Player getSpieler() { return spieler; }

    //andere
    public void addMonster(MonsterCard k){monster.add(k);}
    public void addZauber(Card k){zauber.add(k);}
    public void setFeldzauber(Zauberkarte k){feldzauber = k;}
    public void nimmKarteHeraus(Card a){
        //if a.getClass()==Monsterkarte {
        //    monster.remove(a);
        //}else if a.getClass()==Zauberkarte{
        //    if a.getTyp()==Feldzauber {

        //    }
        }
    }

