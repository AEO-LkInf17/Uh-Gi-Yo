package client.core.gui.screens;

import client.core.Application;
import client.core.gui.managers.AssetManager;
import client.core.gui.managers.ScreenManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class LoadingScreen extends AbstractScreen {

    private Stage stage;
    private Skin skin;
    private Table table;

    private Label label;
    private Circle circle;
    private ProgressBar progressBar;

    private float progress;
    private int percent;

    public LoadingScreen(Application application) {
        super(application);

        AssetManager.getInstance().load("LOADINGSCREEN");

        this.progress = 0f;
        this.percent = Math.round(progress);
    }

    @Override
    public void show() {
        stage = new Stage();
        skin = new Skin(AssetManager.getInstance().get("skin"));
        
        table = new Table();
        label = new Label("Loading", skin);
        circle = new Circle();
        progress = new ProgressBar(0f, 300f, 1f, true, skin);

        table.add(label);
        table.row();
        table.add(progressBar);
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
        stage.dispose();
    }
}
