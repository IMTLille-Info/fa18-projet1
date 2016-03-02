package projet1.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Hero {
	
	private int _x,_y; //coordonnées du personnage
	private Texture _texture; //image du personnage
	
	public Hero(int x, int y){
		this._x = x;
		this._y = y;
		this._texture = new Texture(Gdx.files.internal("0020.png"));
	}
	
	public Texture display(){
		return this._texture;
	}

	public int get_x() {
		return _x;
	}

	public void set_x(int x) {
		this._x = x;
	}

	public int get_y() {
		return _y;
	}

	public void set_y(int y) {
		this._y = y;
	}
	
	public void moveforward(){
		this._y++;
	}
	
	public void moveBack(){
		this._y--;
	}
	
	public void moveRight(){
		this._x++;
	}
	
	public void moveLeft(){
		this._x--;
	}

}
