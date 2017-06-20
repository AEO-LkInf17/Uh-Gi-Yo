package client.core;

import client.core.gui.managers.AssetManager;
import client.core.gui.screens.ScreenEnum;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import client.core.gui.managers.ScreenManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kotcrab.vis.ui.VisUI;

public class Application implements ApplicationListener {

    public Batch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();

        AssetManager.getInstance().initialize();
        AssetManager.getInstance().loadGroups("/test/test.json");

        ScreenManager.getInstance().initialize(this);

        ScreenManager.getInstance().setScreen(ScreenEnum.LOADING);
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
        ScreenManager.getInstance().pause();
    }

    @Override
    public void resume() {
        ScreenManager.getInstance().resume();
    }

    @Override
    public void dispose() {
        ScreenManager.getInstance().dispose();
    }
}