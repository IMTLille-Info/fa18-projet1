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
		switch (bar) {
		case 1:
			sprite.setRegion(textureAtlas.findRegion("1"));
			break;
		case 2:
			sprite.setRegion(textureAtlas.findRegion("2"));
			break;
		case 3:
			sprite.setRegion(textureAtlas.findRegion("3"));
			break;
		case 4:
			sprite.setRegion(textureAtlas.findRegion("4"));
			break;
		case 5:
			sprite.setRegion(textureAtlas.findRegion("5"));
			break;
		case 6:
			sprite.setRegion(textureAtlas.findRegion("6"));
			break;
		case 7:
			sprite.setRegion(textureAtlas.findRegion("7"));
			break;
		case 8:
			sprite.setRegion(textureAtlas.findRegion("8"));
			break;
		case 9:
			sprite.setRegion(textureAtlas.findRegion("9"));
			break;
		case 10:
			sprite.setRegion(textureAtlas.findRegion("10"));
			break;
		default:
			sprite.setRegion(textureAtlas.findRegion("10"));
			System.out.println("problème");
			break;
		}

	}

}
