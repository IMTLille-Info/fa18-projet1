package projet1.core;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Hero extends Creature{
	
	// variable de déplacement
	private boolean movingLeft;
	private boolean movingRight;
	private boolean movingUp;
	private boolean movingDown;

	
	// variables pour les texture(images du hero)
	private TextureRegion[] aGoUp,aGoDown,aGoRight,aGoLeft,aGoUpRight,aGoUpLeft,aGoDownRight,aGoDownLeft;
	private TextureRegion currentTexture;
	
	// Variables pour les animations
	private HashMap<Direction,Animation> Animations;
	private Animation currentAnimation, stopAnimation;
	private static final float FRAMEDURATION = (float) 10; // vitesse animation
	
	private int framenumber;
	
	//Equipement
	private Weapon weapon;
	private Shield shield;
	
	//Vie max
	private float lifeMax;
	public Skill skill;



	/*
	 * Init Hero Class
	 * @param x abscisse
	 * @param y ordonnée
	 */
	public Hero(int x, int y){
		super(x,y, "./Hero_Sprites/HeroSpriteSheet.txt", "0020");
		this.weapon = new Weapon();
		this.shield = new Shield();
		this.skill = new Skill();
		this.life = 1000;
		this.lifeMax = 1000;
		this.weapon.setAtk((float)100);
		this.shield.setDef((float)100);
		this.speed = 150;
		this.skill.setAtk((float)50);
		this.initAnimations();	
	}
	
	/*
	 * Init all Animations with file .txt and .png of Hero
	 */
	private void initAnimations(){
		this.framenumber=0;
		
		// init Texture Region
		this.aGoDown = new TextureRegion[5];
		this.aGoUp = new TextureRegion[5];
		this.aGoRight = new TextureRegion[5];
		this.aGoLeft = new TextureRegion[5];
		this.aGoDownRight = new TextureRegion[5];
		this.aGoUpRight = new TextureRegion[5];
		this.aGoDownLeft = new TextureRegion[5];
		this.aGoUpLeft = new TextureRegion[5];
		
		
		for(int i=0;i<10;i++){
			if(i<5){
				// déplacements verticaux et horizontaux
				this.aGoUp[i]=this._textureAtlas.findRegions("002"+i).first();
				this.aGoDown[i]=this._textureAtlas.findRegions("000"+i).first();
				this.aGoRight[i]=this._textureAtlas.findRegions("001"+i).first();
				this.aGoLeft[i]=this._textureAtlas.findRegions("003"+i).first();
			}
			else {
				// déplacements diagonales
				this.aGoUpRight[i-5]=this._textureAtlas.findRegions("001"+i).first();
				this.aGoDownRight[i-5]=this._textureAtlas.findRegions("000"+i).first();
				this.aGoUpLeft[i-5]=this._textureAtlas.findRegions("002"+i).first();
				this.aGoDownLeft[i-5]=this._textureAtlas.findRegions("003"+i).first();
			}
		}
		
		// init animation
		this.Animations = new HashMap<Direction,Animation>();
		this.Animations.put(Direction.GOUP, new Animation(FRAMEDURATION, this.aGoUp));
		this.Animations.put(Direction.GODOWN, new Animation(FRAMEDURATION, this.aGoDown));
		this.Animations.put(Direction.GORIGHT, new Animation(FRAMEDURATION, this.aGoRight));
		this.Animations.put(Direction.GOLEFT, new Animation(FRAMEDURATION, this.aGoLeft));
		this.Animations.put(Direction.GOUPRIGHT, new Animation(FRAMEDURATION, this.aGoUpRight));
		this.Animations.put(Direction.GODOWNRIGHT, new Animation(FRAMEDURATION, this.aGoDownRight));
		this.Animations.put(Direction.GOUPLEFT, new Animation(FRAMEDURATION, this.aGoUpLeft));
		this.Animations.put(Direction.GODOWNLEFT, new Animation(FRAMEDURATION, this.aGoDownLeft));
		this.Animations.put(Direction.STOPUP, new Animation(FRAMEDURATION, this.aGoUp[0]));
		this.Animations.put(Direction.STOPDOWN, new Animation(FRAMEDURATION, this.aGoDown[0]));
		this.Animations.put(Direction.STOPRIGHT, new Animation(FRAMEDURATION, this.aGoRight[0]));
		this.Animations.put(Direction.STOPLEFT, new Animation(FRAMEDURATION, this.aGoLeft[0]));
		this.Animations.put(Direction.STOPUPRIGHT, new Animation(FRAMEDURATION, this.aGoUpRight[0]));
		this.Animations.put(Direction.STOPDOWNRIGHT, new Animation(FRAMEDURATION, this.aGoDownRight[0]));
		this.Animations.put(Direction.STOPUPLEFT, new Animation(FRAMEDURATION, this.aGoUpLeft[0]));
		this.Animations.put(Direction.STOPDOWNLEFT, new Animation(FRAMEDURATION, this.aGoDownLeft[0]));
		
		// initialisation de départ
		this.currentAnimation = this.Animations.get(Direction.STOPUP);
		this.stopAnimation = this.Animations.get(Direction.STOPUP);
		
	}
	
	public void draw(SpriteBatch batch){
		this.move();
		this.setTexture();		
		this.currentTexture = this.currentAnimation.getKeyFrame(this.framenumber,true);
		this.framenumber= this.framenumber+1 % 5;
		batch.draw(this.currentTexture,this._x,this._y);
		
	}
	
	public void move(){		
		// déplacement du personnage
		if(movingLeft ){
			this._x -= 50 * Gdx.graphics.getDeltaTime();
		}
		if(movingRight && this._x<1550){
			this._x += 100 * Gdx.graphics.getDeltaTime();
		}
		if(movingUp && this._y<1550){
			this._y += 100 * Gdx.graphics.getDeltaTime();
		}
		if(movingDown){
			this._y -= 50 * Gdx.graphics.getDeltaTime();
		}
	}

	public void setTexture() {			
		
		// affichage du personnage selon ses déplacements
		if(movingLeft && !movingUp && !movingDown){ // déplacement vers Ouest
			this.currentAnimation = this.Animations.get(Direction.GOLEFT);
			this.stopAnimation = this.Animations.get(Direction.STOPLEFT);
		}
		if(movingRight && !movingUp && !movingDown){ // déplacement vers Est			
			this.currentAnimation = this.Animations.get(Direction.GORIGHT);
			this.stopAnimation = this.Animations.get(Direction.STOPRIGHT);
		}
		if(movingUp && !movingLeft && !movingRight){ // déplacement vers Nord			
			this.currentAnimation = this.Animations.get(Direction.GOUP);
			this.stopAnimation = this.Animations.get(Direction.STOPUP);
		}
		if(movingDown && !movingLeft && !movingRight){ // déplacement vers Sud			
			this.currentAnimation = this.Animations.get(Direction.GODOWN);
			this.stopAnimation = this.Animations.get(Direction.STOPDOWN);
		}
		if(movingUp && movingRight){ // déplacement vers Nord-Est
			this.currentAnimation = this.Animations.get(Direction.GOUPRIGHT);
			this.stopAnimation = this.Animations.get(Direction.STOPUPRIGHT);
		}
		if(movingUp && movingLeft){ // déplacement vers Nord-Ouest
			this.currentAnimation = this.Animations.get(Direction.GOUPLEFT);
			this.stopAnimation = this.Animations.get(Direction.STOPUPLEFT);
		}
		if(movingDown && movingRight){ // déplacement vers Sud-Est
			this.currentAnimation = this.Animations.get(Direction.GODOWNRIGHT);
			this.stopAnimation = this.Animations.get(Direction.STOPDOWNRIGHT);
		}
		if(movingDown && movingLeft){ // déplacement vers Sud-Ouest
			this.currentAnimation = this.Animations.get(Direction.GODOWNLEFT);
			this.stopAnimation = this.Animations.get(Direction.STOPDOWNLEFT);
		}
		
		// position statique
		if(!(movingLeft || movingRight || movingUp || movingDown))
			this.currentAnimation = this.stopAnimation;
			

			
	}
	
	

	public void setRightMove(boolean t)
    {	
		if(movingLeft && t ) movingLeft = false;
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


	public Shield getShield() {
		return shield;
	}


	public void setShield(Shield shield) {
		this.shield = shield;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public float getLifeMax() {
		return lifeMax;
	}

	public void setLifeMax(float lifeMax) {
		this.lifeMax = lifeMax;
	}


}
