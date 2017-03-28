package server.logic.cards;

public class MonsterCard extends Card {
    protected int attackpoints;
    protected int defensepoints;
    protected int level; //star points
    protected boolean hidden;
    protected boolean offensiveMode;

    public void setAttackpoints(int attackpoints) {
        this.attackpoints = attackpoints;
    }

    public void setDefensepoints(int defensepoints) {
        this.defensepoints = defensepoints;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttackpoints() {
        return attackpoints;
    }

    public int getDefensepoints() {
        return defensepoints;
    }

    public int getStufe() {
        return level;
    }
    public void conceal(){hidden = true;}
    public void reveal(){
        hidden = false;
    }
    public void changemode(){
        offensiveMode = !offensiveMode;
    }

}
