package client.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import client.core.Game;
import client.core.managers.AssetManager;


public class MainMenuScreen extends Screen {

    private Texture texture;
    private Music music;


    public MainMenuScreen(Game game) {
        super(game);

        AssetManager.getInstance().load("group 1");
        AssetManager.getInstance().finishLoading();
        System.out.println("SUCCESS!");
        texture = AssetManager.getInstance().get("badlogic.jpg", Texture.class);
        music = AssetManager.getInstance().get("intro.wav", Music.class); // the instance in the assets will be brought here with a path
        music.play(); //plays music
        music.setVolume((float)1.0);
        music.getVolume();
        music.setLooping(true);
        music.isLooping();



    }

    @Override
    public void show() {
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        super.render(delta);

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(texture, 0, 0);
        game.batch.end();
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
        texture.dispose();
    }
}
