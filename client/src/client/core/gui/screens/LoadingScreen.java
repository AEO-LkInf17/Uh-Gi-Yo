package client.core.gui.screens;

import client.core.Application;
import client.core.gui.managers.AssetManager;
import client.core.gui.managers.ScreenManager;
import client.core.gui.utils.Constants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class LoadingScreen extends AbstractScreen {

    private Stage stage;
    private Table rootTable;
    private Stack panel;
    private ProgressBar progressBar;
    private Label label;


    public LoadingScreen(Application application) {
        super(application);
    }

    @Override
    public void show() {
        stage = new Stage();
        rootTable = new Table();
        rootTable.setFillParent(true);
        stage.addActor(rootTable);
        progressBar = new ProgressBar();
        label = new Label();

        panel.add(progressBar);
        panel.add(label);
        panel.setColor(Constants.GRAY);
    }

    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl20.glClearColor(226f, 226f, 235f, 1f);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
        stage.dispose();
    }
}
