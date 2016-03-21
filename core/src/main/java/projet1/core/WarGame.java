package projet1.core;


import projet1.core.screens.FightScreen;
import projet1.core.screens.GameScreen;
import projet1.core.screens.Splash;

import com.badlogic.gdx.Game;



public class WarGame extends Game {
	
	public Splash splash;
	public GameScreen gameScreen; 
	public FightScreen fightScreen;
	


	@Override
	public void create () {
		splash = new Splash(this);
		gameScreen = new GameScreen();
		fightScreen = new FightScreen();
		setScreen(splash);
		System.out.println("create");
	}


	
}
