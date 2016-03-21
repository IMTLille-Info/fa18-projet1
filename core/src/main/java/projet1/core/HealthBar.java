package projet1.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class HealthBar implements ApplicationListener {

	private SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Sprite sprite;
	
	

	public void create(int bar) {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas("Fight/HealthBar/healthbar.pack");
		AtlasRegion region = textureAtlas.findRegion("10.PNG");
		sprite = new Sprite(region);
		sprite.setRegion(textureAtlas.findRegion(bar+".png"));
			
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
        batch.begin();
        sprite.draw(batch);
        batch.end();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		batch.dispose();
		textureAtlas.dispose();

	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}


}
