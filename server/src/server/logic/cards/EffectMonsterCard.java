package server.logic.cards;

public class EffectMonsterCard extends MonsterCard {
    private String effectName,effectDescription;

    /***
     * @param n name
     * @param t type
     * @param p priority
     * @param l limitation
     * @param a attacpoints
     * @param d defensepoints
     * @param le level
     * @param en effect name
     * @param en effect description
     */
    public EffectMonsterCard(String n,String t,int p,int l,int a,int d,int le, String en, String ed){
        super(n,t,p,l,a,d,le);
        effectName = en;
        effectDescription = ed;
    }

    public String getEffectName() {
        return effectName;
    }

    public String getEffectDescription() {
        return effectDescription;
    }

}
