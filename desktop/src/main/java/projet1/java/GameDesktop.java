package projet1.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import projet1.core.WarGame;

public class GameDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 704;
		config.width = 960;
		new LwjglApplication(new WarGame(), config);
	}
}
