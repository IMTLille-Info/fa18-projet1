package projet1.core;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class HealthBar {

	private TextureAtlas textureAtlas;
	private Sprite sprite;

	public void draw(SpriteBatch batch, int bar) {
		textureAtlas = new TextureAtlas("Fight/HealthBar/healthbar.txt");
		AtlasRegion region = textureAtlas.findRegion("10");
		sprite = new Sprite(region);
		setTexture(bar);
		batch.draw(sprite, 10, 15);
	}

	public void setTexture(int bar) {

		if (bar == 10) {
			sprite.setRegion(textureAtlas.findRegion("10"));
		}
		if (bar == 9) {
			sprite.setRegion(textureAtlas.findRegion("9"));
		}
		if (bar == 8) {
			sprite.setRegion(textureAtlas.findRegion("8"));
		}
		if (bar == 7) {
			sprite.setRegion(textureAtlas.findRegion("7"));
		}
		if (bar == 6) {
			sprite.setRegion(textureAtlas.findRegion("6"));
		}
		if (bar == 5) {
			sprite.setRegion(textureAtlas.findRegion("5"));
		}
		if (bar == 4) {
			sprite.setRegion(textureAtlas.findRegion("4"));
		}
		if (bar == 3) {
			sprite.setRegion(textureAtlas.findRegion("3"));
		}
		if (bar == 2) {
			sprite.setRegion(textureAtlas.findRegion("2"));
		}
		if (bar == 1) {
			sprite.setRegion(textureAtlas.findRegion("1"));
		}

	}

}
