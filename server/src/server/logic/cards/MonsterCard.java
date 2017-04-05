package server.logic.cards;

public class MonsterCard extends Card {
    protected int attackpoints;
    protected int defencepoints;
    protected int level; //star points
    protected boolean hidden;
    protected boolean attackMode;

    public void setAttackpoints(int attackpoints) {
        this.attackpoints = attackpoints;
    }

    public void setDefencepoints(int defencepoints) {
        this.defencepoints = defencepoints;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttackpoints() {
        return attackpoints;
    }

    public int getDefencepoints() {
        return defencepoints;
    }

    public int getStufe() {
        return level;
    }
    public void conceal(){hidden = true;}
    public void reveal(){
        hidden = false;
    }
    public void changemode(){
        attackMode = !attackMode;
    }

}
