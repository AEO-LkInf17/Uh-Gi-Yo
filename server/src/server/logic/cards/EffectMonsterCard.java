package server.logic.cards;

public class EffectMonsterCard extends MonsterCard {
    private String effectName,effectDescription;

    public EffectMonsterCard(String name, String type, int priority, int attackpoints, int defensepoints,
                             int level, String effectName, String effectDescription){
        this.name = name;
        this.type = type;
        this.priority = priority;
        this.attackpoints = attackpoints;
        this.defensepoints = defensepoints;
        this.level = level;
        this.effectName = effectName;
        this.effectDescription = effectDescription;
    }

    public String getEffectName() {
        return effectName;
    }

    public String getEffectDescription() {
        return effectDescription;
    }

}
