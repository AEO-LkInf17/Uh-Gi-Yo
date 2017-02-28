package de.aeoinf17.project_x17;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private String bezeichnung;
    private ArrayList<Karte> ausstattung;
    // Referenzen
    private ArrayList<Karte> karten;
    private Spieler spieler;
    //Methoden

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setAusstattung(){
        this.ausstattung = karten;
    }

    public void setKarten(ArrayList<Karte> karten) {
        this.karten = karten;
    }

    public void setSpieler(Spieler spieler) {
        this.spieler = spieler;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public ArrayList<Karte> getKarten() {
        return karten;
    }

    public Spieler getSpieler() {
        return spieler;
    }
    // andere
    public int getAnzahlKarten(){
        return karten.size();
    }
    public void fuegeKarteHinzu(Karte a){
        karten.add(a);
    }
    public void mischen(){
        Collections.shuffle(karten);
    }
    public Karte gibObersteKarte(){
        return karten.get(0);
    }
    // nimmKarteHeraus wird während des Ziehens aufgerufen.
    public void nimmKarteHeraus(Karte a){
        karten.remove(a);
    }
}
