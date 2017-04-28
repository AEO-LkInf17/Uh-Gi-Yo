package client.core.screens;

import client.core.Game;
import client.core.managers.AssetManager;
import client.core.managers.ScreenManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class LoadingScreen extends AbstractScreen {

    private float progress;

    public LoadingScreen(Game game) {
        super(game);

        this.progress = 0f;
    }

    @Override
    public void show() {
        System.out.println("LOADING");
    }

    public void update(float delta) {
        this.progress = AssetManager.getInstance().getProgress();
        System.out.println(progress);
        if (AssetManager.getInstance().update()) {
            ScreenManager.getInstance().setScreen(ScreenEnum.MAIN_MENU);
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(255f, 255f, 255f, 1f);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
