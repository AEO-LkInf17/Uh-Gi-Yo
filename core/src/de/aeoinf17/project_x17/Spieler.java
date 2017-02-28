package de.aeoinf17.project_x17;

import java.util.ArrayList;

/**
 * Created by schueler on 21.02.2017.
 */
public class Spieler {
    private String name;
    private String rang;
    private int lebenspunkte;
    private int punkte;
    // Referenzen
    private ArrayList<Deck> decks;
    private Deck momentanesDeck;
    private Hand hand;
    private Spielfeldseite spielfeldseite;
    private Friedhof friedhof;

    // Methoden
    // getter / setter
    public void setName(String name) {
        this.name = name;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public void setLebenspunkte(int lebenspunkte) {
        this.lebenspunkte = lebenspunkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    public void setMomentanesDeck(Deck momentanesDeck) {
        this.momentanesDeck = momentanesDeck;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setSpielfeldseite(Spielfeldseite spielfeldseite) {
        this.spielfeldseite = spielfeldseite;
    }

    public void setFriedhof(Friedhof friedhof) {
        this.friedhof = friedhof;
    }

    public String getName() {
        return name;
    }

    public String getRang() {
        return rang;
    }

    public int getLebenspunkte() {
        return lebenspunkte;
    }

    public int getPunkte() { return punkte; }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public Deck getMomentanesDeck() {
        return momentanesDeck;
    }

    public Hand getHand() {
        return hand;
    }

    public Spielfeldseite getSpielfeldseite() {
        return spielfeldseite;
    }

    public Friedhof getFriedhof() {
        return friedhof;
    }
    // andere
    public void zieheKarte(){
        Karte k=momentanesDeck.gibObersteKarte();
        hand.addKarte(k);
        momentanesDeck.nimmKarteHeraus(k);
    }
    public void setzen(Karte k){
    //    spielfeldseite.
    }

}
