package de.aeoinf17.project_x17;

import java.util.ArrayList;

/**
 * Created by schueler on 21.02.2017.
 */
public class Spielfeldseite {
    // Referenzen
    private Spieler spieler;
    private ArrayList<Karte> karten;
    //andere
    public void nimmKarteHeraus(Karte a){
        karten.remove(a);
    }
}
