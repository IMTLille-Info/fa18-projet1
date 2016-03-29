package projet1.core;



import projet1.core.screens.*;

import com.badlogic.gdx.Game;



public class WarGame extends Game {
	
	public Splash splash;

	public FightScreen fightScreen;

	public GameTiledScreen gameTiledScreen;


	@Override
	public void create () {
		splash = new Splash(this);
		gameTiledScreen = new GameTiledScreen();
		fightScreen = new FightScreen(gameTiledScreen.hero, gameTiledScreen.monster);
		setScreen(splash);
		System.out.println("create");
	}


	
}
