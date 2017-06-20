package client.core.gui.screens;

import client.core.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import static com.badlogic.gdx.utils.Align.center;
import static com.badlogic.gdx.utils.Align.top;

public class LoadingScreen extends AbstractScreen {

    private Skin skin;
    private Stage stage;

    private Table rootTable;
    private Table table;

    private final float TABLE_WIDTH = 800f;
    private final float TABLE_HEIGHT = 280f;

    private Label label;

    public LoadingScreen(Application application) {
        super(application);
    }

    @Override
    public void show() {

        skin = new Skin();
        stage = new Stage();

        rootTable = new Table();
        rootTable.setWidth(stage.getWidth());
        rootTable.align(center | top);

        table = new Table();

        label = new Label("LOADING", new Label.LabelStyle());
        label.setX();

        rootTable.add(table);
        stage.addActor(rootTable);
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

        table.setX((width - TABLE_WIDTH) / 2);
        table.setY((height - TABLE_HEIGHT) / 2);

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
