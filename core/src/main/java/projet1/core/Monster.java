package projet1.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Monster extends Creature{

	public Monster(int x, int y, String SheetPath, String FirstTextureRegion) {
		super(x, y, SheetPath, FirstTextureRegion);
		life = 1000;
		speed = 4;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

}
