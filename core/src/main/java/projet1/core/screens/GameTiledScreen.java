package projet1.core.screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import projet1.core.Hero;
import projet1.core.InputKeyboardHero;
import projet1.core.MonsterDragon;
import projet1.core.WarGame;

public class GameTiledScreen extends ApplicationAdapter implements Screen{

	
	private TiledMap tiledMap;
	private TiledMapRenderer tiledMapRenderer;
	private SpriteBatch spritebatch;
	private OrthographicCamera camera;
	private boolean up, right; 
	private InputKeyboardHero inputKeyboardHero ;
	public Hero hero ;
	public MonsterDragon monster;
	public WarGame game;
	public FightScreen fightScreen;
	
	public GameTiledScreen(WarGame game){
		this.game = game;
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.moveCamera();
		if(((560 <=this.hero.getX())&& (this.hero.getX()>= 580))&& ((680<=this.hero.getY())&&( this.hero.getY()>=700))){
			game.setScreen(this.fightScreen);
		}
        camera.update();
        tiledMapRenderer.setView(this.camera);
        tiledMapRenderer.render();
		spritebatch.begin();
		this.hero.draw(this.spritebatch);
		this.monster.draw(this.spritebatch);
		spritebatch.end();
	}

	@Override
	public void show() {
		
		this.camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 800);
		this.up = this.right = false;
		
		camera.update();
		this.tiledMap = new TmxMapLoader().load("GameScreenV3.tmx");
		this.tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		
		this.hero = new Hero(100,100);
		this.monster = new MonsterDragon(530,700);
		fightScreen = new FightScreen(hero, monster, game);
		inputKeyboardHero = new InputKeyboardHero(this.hero);
		Gdx.input.setInputProcessor(inputKeyboardHero);
		
		spritebatch = new SpriteBatch();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	
	private void moveCamera(){
		int Xhero = this.hero.getX();
		int Yhero = this.hero.getY();
		System.out.println(Xhero + " " + Yhero);
		if (Xhero>Gdx.graphics.getWidth()-2 && !this.right){
			camera.translate(800,0);
			this.hero.setX(2);
			this.monster.setX(2);
			this.right=true;
		}else if(Xhero<2 && this.right){
			camera.translate(-800,0);
			this.hero.setX(Gdx.graphics.getWidth()-2);
			this.monster.setX(Gdx.graphics.getWidth()-2);
			this.right=false;
		}
		if(Yhero>Gdx.graphics.getHeight()-2 && !this.up){
			camera.translate(0,800);
			this.hero.setY(2);
			this.monster.setY(2);
			this.up=true;
		}else if(Yhero<1 && this.up){
			camera.translate(0,-800);
			this.hero.setY(Gdx.graphics.getHeight()-2);
			this.monster.setY(Gdx.graphics.getHeight()-2);
			this.up=false;
		}
		
	}
	
}
