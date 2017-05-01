package client.launcher;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import client.core.Application;

public class DesktopLauncher {
    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 600;
        config.width  = 800;
        config.title  = "";
        new LwjglApplication(new Application(), config);
    }
}
