package de.aeoinf17.project_x17;

import java.util.ArrayList;

/**
 * Created by schueler on 21.02.2017.
 */
public abstract class Karte {
    protected String name;
    protected String typ;
    protected int prioritaet;
    protected int limitierung;
    protected boolean angriffsmodus;
    // Referenzen
    protected ArrayList<Deck> decks;
    protected ArrayList<String> eigenschaften;
}
