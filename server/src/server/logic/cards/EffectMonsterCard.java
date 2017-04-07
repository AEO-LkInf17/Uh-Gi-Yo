package server.logic.cards;

public class EffectMonsterCard extends MonsterCard {
    private String effectName,effectDescription;

    public EffectMonsterCard(String n,String t,int p,int l,int a,int d,int le){
        super(n,t,p,l,a,d,le);
    }

    public String getEffectName() {
        return effectName;
    }

    public String getEffectDescription() {
        return effectDescription;
    }

}
