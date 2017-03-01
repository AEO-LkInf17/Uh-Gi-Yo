package de.aeoinf17.project_x17;
import java.util.ArrayList;

public abstract class Karte {
    protected String name;
    protected String typ;
    protected int prioritaet;
    protected int limitierung;
    protected boolean angriffsmodus;
    protected boolean verdeckt;
    // Referenzen
    protected ArrayList<Deck> decks;
    protected ArrayList<String> eigenschaften;

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
    public void setAngriffsmodus(boolean angriffsmodus) {
        this.angriffsmodus = angriffsmodus;
    }
    public void setVerdeckt (boolean verdeckt) { this.verdeckt = verdeckt; }

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
    public boolean isAngriffsmodus() {
        return angriffsmodus;
    }
    public ArrayList getDecks(){ return decks; }
    public ArrayList getEigenschaften(){ return eigenschaften; }

    // andere
    public void addDecks(Deck a) { decks.add(a); }
    public void addEigenschaft(String a){
        eigenschaften.add(a);
    }

    public void verdecken(){
        verdeckt = true;
    }
    public void aufdecken(){
        verdeckt = false;
    }
    public void moduswechsel(){
        angriffsmodus = !angriffsmodus;
    }

}
