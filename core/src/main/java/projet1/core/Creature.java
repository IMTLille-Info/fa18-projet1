package projet1.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Creature {
	protected int _x;
	protected int _y;
	protected Texture _texture;
	protected Sprite _sprite;
	protected LwjglApplicationConfiguration config;
	protected TextureAtlas _textureAtlas;
	protected AtlasRegion _lastMoving;

	
	public Creature(int x, int y, String SheetPath, String FirstTextureRegion){
		this._x = x;
		this._y = y;
		this._textureAtlas = new TextureAtlas(Gdx.files.internal(SheetPath));
		_lastMoving = this._textureAtlas.findRegion(FirstTextureRegion);
		this._sprite = new Sprite(_lastMoving);
		this._sprite.setPosition(this._x,this._y);
		config = new LwjglApplicationConfiguration();	
	}
	
	

	public abstract void draw(SpriteBatch batch);
	

	
	
}
