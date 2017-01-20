package de.aeoinf17.project_x17.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.aeoinf17.project_x17.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Hello World!";
		config.width = 800;
		config.height = 600;
		new LwjglApplication(new Game(), config);
	}
}
