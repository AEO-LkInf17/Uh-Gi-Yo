package client.core.gui.screens;

import client.core.Application;

public abstract class AbstractScreen implements com.badlogic.gdx.Screen {

    protected Application application;

    public AbstractScreen(Application application) {
        this.application = application;
    }

    @Override
    public abstract void show();

    @Override
    public abstract void render(float delta);

    @Override
    public abstract void resize(int width, int height);

    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public abstract void hide();

    @Override
    public abstract void dispose();
}