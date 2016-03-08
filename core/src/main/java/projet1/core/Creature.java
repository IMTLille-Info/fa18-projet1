package projet1.core;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Creature {
	protected int _x;
	protected int _y;
	protected Texture _texture;
	protected Sprite _sprite;
	protected int i;
	protected int vitesseMovement;
	protected boolean movingLeft;
	protected boolean movingRight;
	protected boolean movingUp;
	protected boolean movingDown;
	
	public abstract void Move();
	
}
