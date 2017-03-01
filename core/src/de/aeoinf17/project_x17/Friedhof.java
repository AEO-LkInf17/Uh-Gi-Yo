package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Friedhof extends ArrayList<Karte> {
    // Referenzen
    private Spieler spieler;
    private ArrayList<Karte> karten;

    // getter/setter
    public Spieler getSpieler() { return spieler; }
    public ArrayList<Karte> getKarten() { return karten; }
    //andere
    public void nimmKarteHeraus(Karte a){
        karten.remove(a);
    }
    public Karte gibObersteKarte(){
        return karten.get(0);
    }
}
