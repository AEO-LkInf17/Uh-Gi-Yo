package server.logic.cards;

import server.logic.Deck;

import java.util.ArrayList;

/**
 * Die Klasse Card ist ein Modell für Karten, welches schon einen Großteil der Eigenschaften aller Karten beinhaltet
 * @author Logische Abteilung */
public class Card {



        protected String name;
        protected String type;
        protected int priority;
        protected int max;

        protected ArrayList<Deck> decks;
        protected ArrayList<String> properties;


        public void Card() {

        }

        public void setName(String name) {
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


