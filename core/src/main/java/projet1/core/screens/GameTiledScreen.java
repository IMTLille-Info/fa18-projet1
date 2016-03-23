package projet1.core.screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
	
	private Hero hero ; 
	private InputKeyboardHero inputKeyboardHero ;
	

	@Override
	public void render(float delta) {
		tiledMapRenderer.render();
	}

	@Override
	public void show() {
		this.tiledMap = new TmxMapLoader().load("MapGameScreen.tmx");
		this.tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		
		hero =new Hero(100,100);
		inputKeyboardHero = new InputKeyboardHero(this.hero);
		Gdx.input.setInputProcessor(inputKeyboardHero);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	
}
