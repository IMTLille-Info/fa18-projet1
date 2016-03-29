package projet1.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import projet1.core.WarGame;

public class GameDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 800;
		config.width = 800;
		//config.fullscreen = true;
		new LwjglApplication(new WarGame(), config);
	}
}
