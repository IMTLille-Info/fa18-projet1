package projet1.core;


import projet1.core.screens.GameScreen;
import projet1.core.screens.Splash;

import com.badlogic.gdx.Game;



public class WarGame extends Game {
	
	public Splash splash;
	public GameScreen gameScreen; 
	


	@Override
	public void create () {
		splash = new Splash(this);
		gameScreen = new GameScreen();
		setScreen(splash);
		System.out.println("create");
	}


	
}
