/**
 * GameScreen : show the map with the hero
 */
package projet1.core.screens;

import projet1.core.Hero;
import projet1.core.InputKeyboardHero;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameScreen implements Screen {
	
	private Sprite sprite;
	private Texture texture;
	private SpriteBatch batch;
	private Hero hero ; 
	private InputKeyboardHero inputKeyboardHero ; 
	
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
		batch.begin();
		sprite.draw(batch);
		this.hero.draw(batch);
		batch.end();
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
		batch = new SpriteBatch();
		texture = new Texture("map01.png");
		sprite = new Sprite(texture); 
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		hero =new Hero(100,100);
		inputKeyboardHero = new InputKeyboardHero(this.hero);
		Gdx.input.setInputProcessor(inputKeyboardHero);
	}
}