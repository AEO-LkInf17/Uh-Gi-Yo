package client.core.gui.managers;

import client.core.Application;
import client.core.gui.screens.AbstractScreen;
import client.core.gui.screens.ScreenEnum;

import java.util.Stack;

public class ScreenManager {

    private static ScreenManager instance;

    private Stack<AbstractScreen> abstractScreens;

    private Application application;

    private ScreenManager() {
        super();
    }

    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    public void initialize(Application application) {
        this.abstractScreens = new Stack<AbstractScreen>();
        this.application = application;
    }

    public void resize(int width, int height) {
        abstractScreens.peek().resize(width, height);
    }

    public void render(float delta) {
        abstractScreens.peek().render(delta);
    }

    public void pause() {
        abstractScreens.peek().pause();
    }

    public void resume() {
        abstractScreens.peek().resume();
    }

    public void dispose() {
        for (AbstractScreen abstractScreen : abstractScreens) {
            abstractScreen.dispose();
        }
    }

    public AbstractScreen getScreen() {
        return abstractScreens.peek();
    }

    public void setScreen(ScreenEnum screenEnum) {
        if (!abstractScreens.empty()) {
            abstractScreens.pop().dispose();
        }
        abstractScreens.push(screenEnum.getScreen(application));
    }
}
