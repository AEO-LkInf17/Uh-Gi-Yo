package de.aeoinf17.project_x17;
import java.util.ArrayList;

public abstract class Card {
    protected String name;
    protected String type;
    protected int priotity;
    protected int max;
    // Referenzen
    protected ArrayList<Deck> decks;
    protected ArrayList<String> properties;

    // Methoden
    // getter / setter

    public void Card() {

    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setPriotity(int priotity) {
        this.priotity = priotity;
    }
    public void setMax(int max) {
        this.max = max;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getPriotity() {
        return priotity;
    }
    public int getMax() {
        return max;
    }
    public ArrayList getDecks(){ return decks; }
    public ArrayList getProperties(){ return properties; }

    // andere
    public void addDecks(Deck a) { decks.add(a); }
    public void addEigenschaft(String a){
        properties.add(a);
    }

}
