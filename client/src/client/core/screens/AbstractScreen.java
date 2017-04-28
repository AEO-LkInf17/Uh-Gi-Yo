package client.core.screens;

import client.core.Game;

public abstract class AbstractScreen implements com.badlogic.gdx.Screen {

    protected Game game;

    public AbstractScreen(Game game) {
        this.game = game;
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