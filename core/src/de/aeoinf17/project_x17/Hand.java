package de.aeoinf17.project_x17;

import java.util.ArrayList;

public class Hand extends ArrayList<Karte> {
    // Referenz
    private Spieler spieler;
    private ArrayList<Karte> karten;

    // Methoden
    //getter/setter
    public void setSpieler(Spieler spieler) {
        this.spieler = spieler;
    }
    public void setKarten(ArrayList<Karte> karten) {
        this.karten = karten;
    }
    public Spieler getSpieler() {
        return spieler;
    }
    public ArrayList<Karte> getKarten() {
        return karten;
    }
    //andere
    public void addKarte(Karte a){
        karten.add(a);
    }
    public void nimmKarteHeraus(Karte a){
        karten.remove(a);
    }
}
