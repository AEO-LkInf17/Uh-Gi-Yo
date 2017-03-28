package client.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import client.core.Game;
import client.core.managers.ScreenManager;

public class SplashScreen extends Screen {

    float c = 0f;

    public SplashScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {

    }

    @Override
    public void update(float delta) {
        c += delta;
        if (c >= 3) ScreenManager.getInstance().setScreen(ScreenEnum.MAIN_MENU);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        Gdx.gl.glClearColor(0.18823f, 0.18823f, 0.18823f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
