package projet1.core;


import projet1.core.screens.*;

import com.badlogic.gdx.Game;



public class WarGame extends Game {
	
	public Splash splash;
	public GameScreen gameScreen; 
	public GameTiledScreen gameTiledScreen;
	


	@Override
	public void create () {
		splash = new Splash(this);
		//gameScreen = new GameScreen();
		gameTiledScreen = new GameTiledScreen();
		setScreen(splash);
		System.out.println("create");
	}


	
}
