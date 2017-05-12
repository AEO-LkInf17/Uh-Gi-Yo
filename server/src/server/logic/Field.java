package server.logic;

import server.logic.cards.*;
import server.logic.cards.MonsterCard;

import java.util.ArrayList;

/** The class Field is there for the cards to show where they need to be placed or to remove them from the field
 * @author Simo & Minh
 * @Version 1.0
 */

public class Field {

    private Player player;
    private MonsterCard[] monster = new MonsterCard[5];
    private Card[] spell = new Card[5];
    private SpellCard fieldspell;

    public Field(Player player) {
        this.player = player;
    }
    /**
     * This method is there to add a monstercard
     * @param k k is the card
     */
    public void addMonster(MonsterCard k,int index){monster[index] = k;}

    /**This method is there to show a monster
     *
     * @return returns monster
     */
    public MonsterCard[] getMonster() {return monster;}

    /**This method is there to add a Spell in the ArrayList
     *
     * @param card
     */
    public void addSpell(Card card,int index){spell[index] = card;}

    /**This ArrayList is there to get the Spell from the list
     *
     * @return returns the spell
     */
    public Card[] getSpell() {return spell;}

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

    /**This method is there to  remove a card form the field
     *
     * @param card  Card
     */
    public void removeCard(Card card){
        if (card instanceof MonsterCard) {
            for (int i = 0 ;i < monster.length;i++) {
                if (card == monster[i]) {
                    monster[i] = null;
                }
            }
        }else if (card instanceof SpellCard) {
            for (int i = 0;i < spell.length;i++){
                if (card == spell[i]){
                    spell[i] = null;
                }
            }
        }else if (card instanceof FieldSpellCard){
            fieldspell = null;
        }
    }

    public void add(MonsterCard target) {

    }
}
