/**
 * The Main Screen of the game : Press ENTER to play
 */

package projet1.core.screens;

import projet1.core.WarGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Splash implements Screen {

	private Sprite splash;
	private Texture splashTexture;
	private SpriteBatch splashBatch;
	private WarGame game;
	
	public Splash(WarGame game){
		this.game = game;
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		 splashBatch.begin();
		 splash.draw(splashBatch);
		 splashBatch.end();
		 
		 //when pressing Key ENTER , change screen
		 if (Gdx.input.isKeyPressed(Keys.ENTER)) 
             game.setScreen(game.gameScreen);
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		splashBatch = new SpriteBatch();
		splashTexture = new Texture("splash04.png");
		splash = new Sprite(splashTexture); 
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

}
