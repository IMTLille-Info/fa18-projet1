package projet1.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hero {
	
	private int _x,_y; //coordonnées du personnage
	private Texture _texture; //image du personnage
	private Sprite _sprite;
	boolean movingLeft, movingRight, movingUp, movingDown;
	int i;
	int vitesseMovement;
	
	public Hero(int x, int y){
		this._x = x;
		this._y = y;
		this._texture = new Texture(Gdx.files.internal("./viking/0020.png"));
		this._sprite = new Sprite(this._texture);
		this.i=0;
		this.vitesseMovement = 0;
	}
	
	public void draw(SpriteBatch batch){
		this.updateMotion();
		this._sprite.setPosition(_x, _y);
		this._sprite.draw(batch);
	}

	public void updateMotion(){
		this.vitesseMovement++;
		
		this.i %= 5;
		// déplacement du personnage
		if(movingLeft){
			this._x -= 50 * Gdx.graphics.getDeltaTime();
		}
		if(movingRight){
			this._x += 100 * Gdx.graphics.getDeltaTime();
		}
		if(movingUp){
			this._y += 100 * Gdx.graphics.getDeltaTime();
		}
		if(movingDown){
			this._y -= 50 * Gdx.graphics.getDeltaTime();
		}
		
		
		// affichage du personnage selon ses déplacements
		if(movingLeft && !movingUp && !movingDown){ // déplacement vers Ouest
			if(this.vitesseMovement%8 == 0){
				String path = "./viking/007"+this.i+".png";			
		        this._texture = new Texture(Gdx.files.internal(path));
		        this.i = (this.i + 1)%5;
			}
		}
		if(movingRight && !movingUp && !movingDown){ // déplacement vers Est			
			if(this.vitesseMovement%8 == 0){				
				String path = "./viking/001"+this.i+".png";			
		        this._texture = new Texture(Gdx.files.internal(path));
		        this.i = (this.i + 1)%5;
			}
		}
		if(movingUp && !movingLeft && !movingRight){ // déplacement vers Nord			
			if(this.vitesseMovement%8 == 0){
				String path = "./viking/002"+this.i+".png";			
		        this._texture = new Texture(Gdx.files.internal(path));
		        this.i = (this.i + 1)%5;
			}
				
		}
		if(movingDown && !movingLeft && !movingRight){ // déplacement vers Sud			
			if(this.vitesseMovement%8 == 0){
				String path = "./viking/000"+this.i+".png";			
		        this._texture = new Texture(Gdx.files.internal(path));
		        this.i = (this.i + 1)%5;
			}
		}
		if(movingUp && movingRight){ // déplacement vers Nord-Est
			if(this.vitesseMovement%8 == 0){
				this.i = (this.i + 1)%5 + 5;
				String path = "./viking/001"+this.i+".png";			
		        this._texture = new Texture(Gdx.files.internal(path));		        
			}
		}
		if(movingUp && movingLeft){ // déplacement vers Nord-Ouest
			if(this.vitesseMovement%8 == 0){
				this.i = (this.i + 1)%5 + 5;
				String path = "./viking/009"+this.i+".png";			
		        this._texture = new Texture(Gdx.files.internal(path));		        
			}
		}
		if(movingDown && movingRight){ // déplacement vers Sud-Est
			if(this.vitesseMovement%8 == 0){
				this.i = (this.i + 1)%5 + 5;
				String path = "./viking/000"+this.i+".png";			
		        this._texture = new Texture(Gdx.files.internal(path));		        
			}
		}
		if(movingDown && movingLeft){ // déplacement vers Sud-Ouest
			if(this.vitesseMovement%8 == 0){
				this.i = (this.i + 1)%5 + 5;
				String path = "./viking/008"+this.i+".png";			
		        this._texture = new Texture(Gdx.files.internal(path));		        
			}
		}
		
		
		if(!(movingLeft || movingRight || movingUp || movingDown)) // position statique
			this._texture = new Texture(Gdx.files.internal("./viking/0020.png"));
		
		this._sprite = new Sprite(this._texture);
		
	}

	public void setRightMove(boolean t)
    {
        if(movingLeft && t) movingLeft = false;
        movingRight = t;
    }
	
	public void setLeftMove(boolean t)
    {
        if(movingRight && t) movingRight = false;
        movingLeft = t;
    }
	
	public void setUpMove(boolean t)
    {
        if(movingDown && t) movingDown = false;
        movingUp = t;
    }
	
	public void setDownMove(boolean t)
    {
        if(movingUp && t) movingUp = false;
        movingDown = t;
    }

}
