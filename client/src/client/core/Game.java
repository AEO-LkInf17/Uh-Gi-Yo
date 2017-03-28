package client.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import client.core.managers.AssetManager;
import client.core.managers.ScreenManager;
import client.core.screens.ScreenEnum;

public class Game implements ApplicationListener {

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        AssetManager.getInstance().initialize("test.json");

        ScreenManager.getInstance().initialize(this);
        ScreenManager.getInstance().setScreen(ScreenEnum.SPLASH);
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
        AssetManager.getInstance().dispose();
        batch.dispose();
    }
}

