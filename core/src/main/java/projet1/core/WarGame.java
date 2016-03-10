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
		//texture = new Texture(Gdx.files.internal("map01.png"));
		//batch = new SpriteBatch();
		//hero = new Hero(100,100);
		//inputKeyboard = new InputKeyboard(this.hero);
		//Gdx.input.setInputProcessor(inputKeyboard);
		System.out.println("create");
	}

	@Override
	public void resize (int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void render () {
		super.render();
		//batch.begin();
		//batch.draw(texture, 0, 0);
		//this.hero.draw(batch);
		//batch.end();
	}

	@Override
	public void pause () {
		super.pause();
	}


	@Override
	public void resume () {
		super.resume();
	}

	@Override
	public void dispose () {
		super.dispose();
		//texture.dispose();
		//batch.dispose();
	}
	
}
