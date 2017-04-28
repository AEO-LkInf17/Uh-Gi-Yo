package client.core.screens;

import client.core.Game;
import client.core.managers.AssetManager;
import client.core.managers.ScreenManager;

public class LoadingScreen extends AbstractScreen {

    private float progress;

    public LoadingScreen(Game game) {
        super(game);

        this.progress = 0f;
    }

    @Override
    public void show() {

    }

    public void update(float delta) {
        this.progress = AssetManager.getInstance().getProgress();
        if (AssetManager.getInstance().update()) {
            ScreenManager.getInstance().setScreen(ScreenEnum.MAIN_MENU);
        }
    }

    @Override
    public void render(float delta) {

        update(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
