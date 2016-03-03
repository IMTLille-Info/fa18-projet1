package projet1.core;

import com.badlogic.gdx.Gdx;
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
		case Keys.ESCAPE :
			Gdx.app.exit();
			break;
		case Keys.UP : 
			this.hero.setUpMove(true);
			break;
		case Keys.DOWN : 
			this.hero.setDownMove(true);
			break;
		case Keys.LEFT : 
			this.hero.setLeftMove(true);
			break;
		case Keys.RIGHT : 
			this.hero.setRightMove(true);
			break;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode){
		case Keys.UP : 
			this.hero.setUpMove(false);
			break;
		case Keys.DOWN : 
			this.hero.setDownMove(false);
			break;
		case Keys.LEFT : 
			this.hero.setLeftMove(false);
			break;
		case Keys.RIGHT : 
			this.hero.setRightMove(false);
			break;
		}
		return true;
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
