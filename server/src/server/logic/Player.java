package server.logic;

import server.logic.cards.Card;
import server.logic.cards.MonsterCard;
import server.logic.exceptions.PlaceAlreadyTakenException;
import server.user.User;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String rank;
    private int lifepoints;
    private int points;
    private Game game;
    private User user;

    private ArrayList<Deck> decks;
    private Deck momentaryDeck;
    private Hand hand;
    private Field gamefield;
    private Graveyard graveyard;

    private int denyDrawing;
    private int denyAttack;
    private int denySpellCardEffect;
    private int denyTrapCardEffect;
    private int denyMonsterCardEffect;
    private int denySummon;
    private int denySpecialSummon;
    private int denyPositionChange;
    private int denySetSpell;
    private int denySetTrap;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getRank() {
        return rank;
    }

    public void setLifepoints(int lifepoints) {
        this.lifepoints = lifepoints;
    }
    public int getLifepoints() {
        return lifepoints;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public int getPoints() { return points; }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }
    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public void setMomentaryDeck(Deck momentaryDeck) {
        this.momentaryDeck = momentaryDeck;
    }
    public Deck getMomentaryDeck() {
        return momentaryDeck;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public Hand getHand() {
        return hand;
    }

    public void setGamefield(Field gamefield) {
        this.gamefield = gamefield;
    }
    public Field getGamefield() {
        return gamefield;
    }

    public void setGraveyard(Graveyard graveyard) {
        this.graveyard = graveyard;
    }
    public Graveyard getGraveyard() {
        return graveyard;
    }

    public void setGame (Game g){game = g;}
    public Game getGame (){return game;}

    public int getDenyDrawing() {
        return denyDrawing;
    }

    public int getDenyAttack() {
        return denyAttack;
    }

    public int getDenySpellCardEffect() {
        return denySpellCardEffect;
    }

    public int getDenyTrapCardEffect() {
        return denyTrapCardEffect;
    }

    public int getDenyMonsterCardEffect() {
        return denyMonsterCardEffect;
    }

    public int getDenySummon() {
        return denySummon;
    }

    public int getDenySpecialSummon() {
        return denySpecialSummon;
    }

    public int getDenyPositionChange() {
        return denyPositionChange;
    }

    public int getDenySetSpell() {
        return denySetSpell;
    }

    public int getDenySetTrap() {
        return denySetTrap;
    }

    public void setDenyDrawing(int denyDrawing) {
        this.denyDrawing = denyDrawing;
    }

    public void setDenyAttack(int denyAttack) {
        this.denyAttack = denyAttack;
    }

    public void setDenySpellCardEffect(int denySpellCardEffect) {
        this.denySpellCardEffect = denySpellCardEffect;
    }

    public void setDenyTrapCardEffect(int denyTrapCardEffect) {
        this.denyTrapCardEffect = denyTrapCardEffect;
    }

    public void setDenyMonsterCardEffect(int denyMonsterCardEffect) {
        this.denyMonsterCardEffect = denyMonsterCardEffect;
    }

    public void setDenySummon(int denySummon) {
        this.denySummon = denySummon;
    }

    public void setDenySpecialSummon(int denySpecialSummon) {
        this.denySpecialSummon = denySpecialSummon;
    }

    public void setDenyPositionChange(int denyPositionChange) {
        this.denyPositionChange = denyPositionChange;
    }

    public void setDenySetSpell(int denySetSpell) {
        this.denySetSpell = denySetSpell;
    }

    public void setDenySetTrap(int denySetTrap) {
        this.denySetTrap = denySetTrap;
    }

    public static Player getPlayerByUser(User user){ //dirty implementation in Game, i (Julian) will change it later
        List<Player> players = Game.getPlayers();
        for(Player player : players) {
            if(player.getUser().equals(user))
                return player;
        }
        return null;
    }

    public void drawCard(){
        Card card = momentaryDeck.getTopCard();
        hand.addCard(card);
        momentaryDeck.removeCard(card);
    }
    public void set(MonsterCard card,int index){
        card.reveal();
        try {
            gamefield.addMonster(card,index);
        } catch (PlaceAlreadyTakenException e) {
            e.printStackTrace();
        }
        hand.removeCard(card);
    }
    public void place(MonsterCard card,int index){
        card.conceal();
        try {
            gamefield.addMonster(card,index);
        } catch (PlaceAlreadyTakenException e) {
            e.printStackTrace();
        }
        hand.removeCard(card);
    }
    public void changeposition(MonsterCard card){
        card.changemode();
    }
    public void flip(MonsterCard card){
        card.reveal();
    }

    public void destroy(Card card){
        graveyard.add(card);
        gamefield.removeCard(card);
    }
    public void revive(MonsterCard card,int index){
        try {
            gamefield.addMonster(card,index);
        } catch (PlaceAlreadyTakenException e) {
            e.printStackTrace();
        }
        graveyard.remove(card);
    }
    public User getUser() {
        return user;
    }
}
