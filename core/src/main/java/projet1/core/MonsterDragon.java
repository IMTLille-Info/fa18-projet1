package projet1.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

public class MonsterDragon extends Enemy{
	private TextureAtlas atlas = new TextureAtlas();
	private TextureRegion monster = new TextureRegion();
	TextureRegion monsterRegion;
	private Animation Dragonwalk;
	AtlasRegion region1 ;
	//AtlasRegion region2;
	private Array<TextureRegion>frames;
	public MonsterDragon(int x, int y){
		this._x =x;
		this._y = y;
		atlas = new TextureAtlas("./dragon_walk/dragon_walk.pack");
		region1= atlas.findRegion("go_down");
		this._sprite = new Sprite(region1);
		this.i=0;
		this.vitesseMovement = 0;
	}
	
	public void draw(SpriteBatch batch){
		this.Move();
		this._sprite.setPosition(_x, _y);
		this._sprite.draw(batch);
	}
	@Override
	public void Move() {
		// TODO Auto-generated method stub
	
		
	}

}
