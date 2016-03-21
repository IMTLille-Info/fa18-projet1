package projet1.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import projet1.core.Creature;
import projet1.core.Hero;


public class FightScreen implements Screen {

	//
	private Sprite sprite;
	private Texture texture;
	private SpriteBatch batch;
	private BitmapFont font; 
	private Stage stage;
	private TextureAtlas buttonTexture;
	private Skin skin;
	private Table table;
	private TextButton attack;
	
	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		batch.begin();
		sprite.draw(batch);
		batch.end();
		stage.act(arg0);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		texture = new Texture("Fight/splash03.jpg");
		sprite = new Sprite(texture); 
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
				
		stage = new Stage();
		Gdx.input.setInputProcessor(stage); 
		buttonTexture = new TextureAtlas("Fight/Skills/attackSkill.pack");
		skin = new Skin(buttonTexture);
		font = new BitmapFont(Gdx.files.internal("screens/joker.fnt"),false);
		table = new Table(skin);
		//table.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
		TextButtonStyle style = new TextButtonStyle();
		style.up =skin.getDrawable("Attack_skill");
		style.down =skin.getDrawable("Attack_skill-clicked");
		style.font = font;
		attack = new TextButton("",style);
		attack.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				//game.setScreen(game.gameScreen);
			}
		});
		table.add(attack).width(50).height(50).padBottom(75).padLeft(1200);
		stage.addActor(table);

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
