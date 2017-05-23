package server.logic.Activity;

import server.logic.cards.MonsterCard;
import server.util.Timer;

import java.util.HashMap;
import java.util.Map;

public abstract class Activity {
    abstract public void handleActivity();
    abstract public String getName();

    private static int idCounter = 0;
    protected static int getAvailableID() {
        return idCounter++;
    }
    private static Map<Integer, Activity> activities = new HashMap<Integer, Activity>();
    private int id = getAvailableID();
    public int getID() {
        return id;
    }

    private Timer timer;

    public Activity() {
        activities.put(new Integer(getID()), this);
    }

    public static Activity getActiviyID(int id) {
        return activities.get(new Integer(id));
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    public boolean checkTimer() {
        return timer.check();
    }
    public void deactivateTimer() {
        timer.deactivate();
    }
}
