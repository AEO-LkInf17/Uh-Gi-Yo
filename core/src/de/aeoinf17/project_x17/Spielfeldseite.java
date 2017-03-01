package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Spielfeldseite extends ArrayList<Karte> {
    // Referenzen
    private Spieler spieler;
    private ArrayList<Karte> karten;

    // Methoden
    // getter/setter
    public Spieler getSpieler() { return spieler; }
    public ArrayList<Karte> getKarten() { return karten; }
    //andere
    public void nimmKarteHeraus(Karte a){
        karten.remove(a);
    }
    public void addKarte(Karte k){
        karten.add(k);
    }
}
