package de.aeoinf17.project_x17;
import java.util.ArrayList;

public abstract class Karte {
    protected String name;
    protected String typ;
    protected int prioritaet;
    protected int limitierung;
    // Referenzen
    protected ArrayList<Deck> decks;
    protected ArrayList<Eigenschaft> eigenschaften;

    // Methoden
    // getter / setter

    public void setName(String name) {
        this.name = name;
    }
    public void setTyp(String typ) {
        this.typ = typ;
    }
    public void setPrioritaet(int prioritaet) {
        this.prioritaet = prioritaet;
    }
    public void setLimitierung(int limitierung) {
        this.limitierung = limitierung;
    }

    public String getName() {
        return name;
    }
    public String getTyp() {
        return typ;
    }
    public int getPrioritaet() {
        return prioritaet;
    }
    public int getLimitierung() {
        return limitierung;
    }
    public ArrayList getDecks(){ return decks; }
    public ArrayList getEigenschaften(){ return eigenschaften; }

    // andere
    public void addDecks(Deck a) { decks.add(a); }
    public void addEigenschaft(Eigenschaft a){
        eigenschaften.add(a);
    }
    //änderung Test
}
