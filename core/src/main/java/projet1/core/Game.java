package projet1.core;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class Game implements ApplicationListener {
	Texture texture;
	SpriteBatch batch;

	@Override
	public void create () {
		texture = new Texture(Gdx.files.internal("map01.png"));
		batch = new SpriteBatch();
	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(texture, 0, 0);
		batch.draw(new Texture(Gdx.files.internal("0020.png")),200,500);
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
	}
}
