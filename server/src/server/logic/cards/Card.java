package server.logic.cards;

import server.logic.Deck;

import java.util.ArrayList;

public abstract class Card {
    protected String name;
    protected String type;

    protected int priority;
    protected int limitation;

    protected ArrayList<Deck> decks;
    protected ArrayList<String> properties;

    /***
     * @param n name
     * @param t type
     * @param p priority
     * @param l limitation
     */
    public Card(String n,String t,int p,int l) {
        name = n;
        type = t;
        priority = p;
        limitation = l;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getPriority() {
        return priority;
    }

    public void setLimitation(int max) {
        this.limitation = limitation;
    }
    public int getLimitation() {
        return limitation;
    }

    public void addDecks(Deck a) { decks.add(a); }
    public ArrayList getDecks(){ return decks; }

    public void addProperty(String a){
        properties.add(a);
    }
    public ArrayList getProperties(){ return properties; }
}
