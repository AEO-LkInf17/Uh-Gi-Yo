package client.core.managers;

import client.core.Game;
import client.core.screens.Screen;
import client.core.screens.ScreenEnum;

import java.util.Stack;

public class ScreenManager {

    private static ScreenManager instance;

    private Stack<Screen> screens;

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
        this.screens = new Stack<Screen>();
        this.game = game;
    }

    public void resize(int width, int height) {
        screens.peek().resize(width, height);
    }

    public void render(float delta) {
        screens.peek().render(delta);
    }

    public void dispose() {
        for (Screen screen : screens) {
            screen.dispose();
        }
    }

    public Screen getScreen() {
        return screens.peek();
    }

    public void setScreen(ScreenEnum screenEnum) {
        if (!screens.empty()) {
            screens.pop().dispose();
        }
        screens.push(screenEnum.getScreen(game));
    }
}
