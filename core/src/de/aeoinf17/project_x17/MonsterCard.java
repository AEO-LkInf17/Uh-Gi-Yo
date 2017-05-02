package de.aeoinf17.project_x17;

public class MonsterCard extends Card {
    protected int attackpoints;
    protected int defencepoints;
    protected int rank;
    protected boolean facedown;
    protected boolean attackmode;

    public void setAttackpoints(int attackpoints) {
        this.attackpoints = attackpoints;
    }

    public void setDefencepoints(int defencepoints) {
        this.defencepoints = defencepoints;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getAttackpoints() {
        return attackpoints;
    }

    public int getDefencepoints() {
        return defencepoints;
    }

    public int getRank() {
        return rank;
    }
    public void conceal(){
        facedown = true;
    }
    public void reveal(){
        facedown = false;
    }
    public void changemode(){
        attackmode = !attackmode;
    }

}
