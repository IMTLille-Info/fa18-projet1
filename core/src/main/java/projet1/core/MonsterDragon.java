package projet1.core;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

public class MonsterDragon extends Creature{
	TextureRegion monsterRegion;
	AtlasRegion region1 ;
	//AtlasRegion region2;
	private Array<TextureRegion>frames;
	static String path = "./dragon_walk/dragon_walk.pack";
	static String firstTextureRegion = "go_down";
	public MonsterDragon(int x, int y){
		super(x,y,path,firstTextureRegion);
		this._sprite = new Sprite(region1);
		
	}
	
	public void draw(SpriteBatch batch){
		this._sprite.setPosition(_x, _y);
		this._sprite.draw(batch);
	}
	

}
