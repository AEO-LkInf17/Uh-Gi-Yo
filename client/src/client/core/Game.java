package client.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import client.core.managers.ScreenManager;

public class Game implements ApplicationListener {

    @Override
    public void create() {
        ScreenManager.getInstance().initialize(this);
    }

    @Override
    public void resize(int width, int height) {
        ScreenManager.getInstance().resize(width, height);
    }

    @Override
    public void render() {
        ScreenManager.getInstance().render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        ScreenManager.getInstance().dispose();
    }
}

