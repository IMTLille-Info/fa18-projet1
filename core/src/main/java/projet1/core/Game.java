package projet1.core;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;


public class Game implements ApplicationListener {
	private Texture texture;
	private SpriteBatch batch;
	private Hero hero;
	private InputKeyboard inputKeyboard;

	@Override
	public void create () {
		texture = new Texture(Gdx.files.internal("map01.png"));
		batch = new SpriteBatch();
		hero = new Hero(100,100);
		inputKeyboard = new InputKeyboard(this.hero);
		Gdx.input.setInputProcessor(inputKeyboard);
		System.out.println("create");
	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(texture, 0, 0);
		batch.draw(this.hero.display(),this.hero.get_x() ,this.hero.get_y());
		batch.end();
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
		texture.dispose();
		batch.dispose();
	}
	
}
