package projet1.core.screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import projet1.core.Hero;
import projet1.core.InputKeyboardHero;

public class GameTiledScreen extends ApplicationAdapter implements Screen{

	//private Texture img;
	private TiledMap tiledMap;
	private TiledMapRenderer tiledMapRenderer;
	private SpriteBatch spritebatch;
	private Sprite sprite;
	private OrthographicCamera camera;
	
	private Hero hero ; 
	private InputKeyboardHero inputKeyboardHero ;
	

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        tiledMapRenderer.setView(this.camera);
        tiledMapRenderer.render();
		spritebatch.begin();
		this.hero.draw(this.spritebatch);
		spritebatch.end();
	}

	@Override
	public void show() {
		this.camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		this.tiledMap = new TmxMapLoader().load("GameScreenV2.tmx");
		this.tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		
		this.hero = new Hero(100,100);
		inputKeyboardHero = new InputKeyboardHero(this.hero);
		Gdx.input.setInputProcessor(inputKeyboardHero);
		
		spritebatch = new SpriteBatch();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	
}
