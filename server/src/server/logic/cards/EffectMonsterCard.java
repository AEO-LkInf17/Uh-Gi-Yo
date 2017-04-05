package server.logic.cards;

public class EffectMonsterCard  extends MonsterCard {
    public EffectMonsterCard(String n, String t, int p, int m){
        name = n;
        type = t;
        priority = p;
        max = m;
    }
}
