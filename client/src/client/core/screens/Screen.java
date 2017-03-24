package client.core.screens;

import client.core.Game;

public abstract class Screen implements com.badlogic.gdx.Screen {

    protected Game game;

    public Screen(Game game) {
        this.game = game;
    }

    @Override
    public abstract void show();

    public abstract void update(float delta);

    @Override
    public void render(float delta) {
        this.update(delta);
    }

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