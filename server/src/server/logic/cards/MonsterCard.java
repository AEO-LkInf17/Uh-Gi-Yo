package server.logic.cards;

import server.logic.exceptions.AttackfailedException;
import server.logic.exceptions.AttacksuccessfulException;
import server.logic.exceptions.SubtractLifepointsException;

public class MonsterCard extends Card {
    protected int attackpoints;
    protected int defensepoints;
    protected int level; //star points

    protected boolean hidden;
    protected boolean offensiveMode;

    /***
     * @param n name
     * @param t type
     * @param p priority
     * @param l limitation
     * @param a attackpoints
     * @param d defensepoints
     * @param le level
     */

    public MonsterCard(String n,String t,int p,int l,int a,int d,int le){
        super(n,t,p,l);
        attackpoints = a;
        defensepoints = d;
        level = le;
    }

    public void setAttackpoints(int attackpoints) {
        this.attackpoints = attackpoints;
    }
    public int getAttackpoints() {
        return attackpoints;
    }

    public void setDefensepoints(int defensepoints) {
        this.defensepoints = defensepoints;
    }
    public int getDefensepoints() {
        return defensepoints;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

    public boolean getOffensivmode(){return offensiveMode;}

    public void conceal(){hidden = true;}
    public void reveal(){
        hidden = false;
    }
    public void changemode(){
        offensiveMode = !offensiveMode;
    }

    public void attack(MonsterCard target)throws AttacksuccessfulException,AttackfailedException,SubtractLifepointsException{
        if (offensiveMode){
            if (target == null){
                throw new SubtractLifepointsException(attackpoints);
            }
            if (target.getOffensivmode()) {
                if (attackpoints > target.getAttackpoints()){
                    throw new AttacksuccessfulException();
                    //throw new SubtractLifepointsException(8000);
                }else{
                    throw new AttackfailedException();
                }
            }else{
                if (attackpoints > target.getDefensepoints()){
                    throw new AttacksuccessfulException();
                }else{
                    throw new AttackfailedException();
                }
            }
        }
    }
}

