package projet1.core;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class InputKeyboard implements InputProcessor {
	
	private Hero hero;
	
	public InputKeyboard(Hero hero){
		this.hero = hero;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode){
		case Keys.UP : 
			this.hero.moveforward(true);
			return true;
		case Keys.DOWN : 
			this.hero.moveBack(true);
			return true;
		case Keys.LEFT : 
			this.hero.moveLeft(true);
			return true;
		case Keys.RIGHT : 
			this.hero.moveRight(true);
			return true;
		default:
			return false;
		}		
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode){
		case Keys.UP : 
			this.hero.moveforward(false);
			return true;
		case Keys.DOWN : 
			this.hero.moveBack(false);
			return true;
		case Keys.LEFT : 
			this.hero.moveLeft(false);
			return true;
		case Keys.RIGHT : 
			this.hero.moveRight(false);
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
