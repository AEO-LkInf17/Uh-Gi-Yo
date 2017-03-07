package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Spielfeldseite extends ArrayList<Karte> {
    // Referenzen
    private Spieler spieler;
    private ArrayList<Monsterkarte> monster;
    private ArrayList<Karte> zauber;
    private Zauberkarte feldzauber;
    // Methoden
    // getter/setter
    public ArrayList<Monsterkarte> getMonster() {return monster;}
    public ArrayList<Karte> getZauber() {return zauber;}
    public Zauberkarte getFeldzauber() {return feldzauber;}
    public Spieler getSpieler() { return spieler; }

    //andere
    public void addMonster(Monsterkarte k){monster.add(k);}
    public void addZauber(Karte k){zauber.add(k);}
    public void setFeldzauber(Zauberkarte k){feldzauber = k;}
    public void nimmKarteHeraus(Karte a){
        //if a.getClass()==Monsterkarte {
        //    monster.remove(a);
        //}else if a.getClass()==Zauberkarte{
        //    if a.getTyp()==Feldzauber {

        //    }
        }

    }
}
