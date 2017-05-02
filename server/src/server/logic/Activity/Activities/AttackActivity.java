package server.logic.Activity.Activities;

import server.logic.Activity.Activity;
import server.logic.cards.Card;
import server.logic.cards.MonsterCard;
import server.logic.exceptions.*;

public class AttackActivity extends Activity{
    private static final int TARGET_IS_NULL = 0;
    private static final int ATTACK_SUCCESSFUL_PLUS_OVERFLOATING_DAMAGE = 1;
    private static final int DESTROY_BOTH = 2;
    private static final int ATTACK_FAILED = 3;
    private static final int ATTACK_SUCCESSFUL = 4;
    private static final int NOTHING_HAPPENED = 5;
    private static final int ATTACK_FAILED_PLUS_OVERFLOATING_DAMAGE = 6;

    @Override
    public void handleActivity(MonsterCard target, MonsterCard attacker) {
        switch(attacker.attack(target)){
            case AttackActivity.TARGET_IS_NULL:
            case AttackActivity.ATTACK_SUCCESSFUL_PLUS_OVERFLOATING_DAMAGE: target.selfDistruction();
                target.getPlayer().setLifepoints((target.getPlayer().getLifepoints())-(attacker.getAttackpoints()-target.getAttackpoints())); break;
            case AttackActivity.DESTROY_BOTH: target.selfDistruction(); attacker.selfDistruction(); break;
            case AttackActivity.ATTACK_FAILED: attacker.selfDistruction(); break;
        }


    }
}
