package client.core.gui.screens;

import client.core.Application;
import client.core.gui.managers.AssetManager;
import client.core.gui.managers.ScreenManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class LoadingScreen extends AbstractScreen {

    private Stage stage;

    private float progress;

    public LoadingScreen(Application application) {
        super(application);

        this.progress = 0f;
    }

    @Override
    public void show() {

        stage = new Stage();
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
        Gdx.gl20.glClearColor(226f, 226f, 235f, 1f);
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
