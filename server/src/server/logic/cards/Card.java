package server.logic.cards;
import server.logic.Deck;

import java.util.ArrayList;

/** This class is here to give cards a type/attribute and define them
 * @author minh & simo
 * @version 1
 */

public abstract class Card {
    protected String name;
    protected String type;
    protected int priority;
    protected int max;
    /** this attribute puts a limit on to how many cards of the same name one can have in a deck
     */
    // Referenzen
    protected ArrayList<Deck> decks;
    protected ArrayList<String> properties;

    // Methoden
    // getter / setter

    public void Card() {
    }

    p ublic void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setPriority(int priority) {
        this.priority = priority;
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
    public int getPriority() {
        return priority;
    }
    public int getMax() {
        return max;
    }
    public ArrayList getDecks(){ return decks; }
    public ArrayList getProperties(){ return properties; }

    // andere
    public void addDecks(Deck a) { decks.add(a); }
    public void addProperty(String a){
        properties.add(a);
    }

}
