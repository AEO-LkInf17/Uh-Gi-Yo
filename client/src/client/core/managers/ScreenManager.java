package client.core.managers;

import client.core.Game;
import client.core.screens.AbstractScreen;
import client.core.screens.ScreenEnum;

import java.util.Stack;

public class ScreenManager {

    private static ScreenManager instance;

    private Stack<AbstractScreen> abstractScreens;

    private Game game;

    private ScreenManager() {
        super();
    }

    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    public void initialize(Game game) {
        this.abstractScreens = new Stack<AbstractScreen>();
        this.game = game;
    }

    public void resize(int width, int height) {
        abstractScreens.peek().resize(width, height);
    }

    public void render(float delta) {
        abstractScreens.peek().render(delta);
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
        abstractScreens.push(screenEnum.getScreen(game));
    }
}
