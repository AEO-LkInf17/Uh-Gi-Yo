package server.logic;

import server.logic.cards.*;
import server.logic.cards.MonsterCard;

import java.util.ArrayList;

/** The class Field is there for the cards to show where they need to be placed or to remove them from the field
 * @author Simo & Minh
 * @Version 1.0
 */

public class Field extends ArrayList<Card> {

    private Player player;
    private ArrayList<MonsterCard> monster;
    private ArrayList<Card> spell;
    private SpellCard fieldspell;

    /**
     * This method is there to add a monstercard
     * @param k k is the card
     */
    public void addMonster(MonsterCard k){monster.add(k);}

    /**This method is there to show a monster
     *
     * @return returns monster
     */
    public ArrayList<MonsterCard> getMonster() {return monster;}

    /**This method is there to add a Spell in the ArrayList
     *
     * @param card
     */
    public void addSpell(Card card){spell.add(card);}

    /**This ArrayList is there to get the Spell from the list
     *
     * @return returns the spell
     */
    public ArrayList<Card> getSpell() {return spell;}

    /**This Method is there to set a fieldspell in the field
     *
     * @param card is there to set a fieldspellcard
     */
    public void setFieldspell(SpellCard card){fieldspell = card;}

    /**This method is there to get the fieldspell
     *
     * @return returns fieldspell
     */
    public SpellCard getFieldspell() {return fieldspell;}

    /**This method is there to get the player
     *
     * @return returns the player
     */
    public Player getPlayer() { return player; }

    public void removeCard(Card card){
        //if a.getClass()==MonsterCard {
        //    monster.remove(a);
        //}else if a.getClass()==Spellcard{
        //    if a.getTyp()==fieldspell {

        //    }
    }
}
