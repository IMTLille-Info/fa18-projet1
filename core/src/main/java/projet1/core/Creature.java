package projet1.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public abstract class Creature {
	//images
	protected int _x;
	protected int _y;
	protected Texture _texture;
	protected Sprite _sprite;
	protected LwjglApplicationConfiguration config;
	protected TextureAtlas _textureAtlas;
	protected AtlasRegion _lastMoving;
	//stats
	protected float def;
	protected float atk;
	protected float speed;
	protected float life;
	protected boolean token;
	//barre de vie
	public HealthBar healthbar;


	
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
	
	public void drawFight(SpriteBatch batch, int x, int y){
		this._sprite.setPosition(x, y);
		this._sprite.draw(batch);
	}
	
	public float getDef() {
		return def;
	}



	public void setDef(float def) {
		this.def = def;
	}



	public float getAtk() {
		return atk;
	}



	public void setAtk(float atk) {
		this.atk = atk;
	}



	public float getSpeed() {
		return speed;
	}



	public void setSpeed(float speed) {
		this.speed = speed;
	}



	public float getLife() {
		return life;
	}



	public void setLife(float life) {
		this.life = life;
	}



	public boolean isToken() {
		return token;
	}



	public void setToken(boolean token) {
		this.token = token;
	}

	public void setX(int pos){
		this._x=pos;
	}
	
	public void setY(int pos){
		this._y=pos;
	}
	public int getX(){
		return this._x;
	}
	
	public int getY(){
		return this._y;
	}
	
}
