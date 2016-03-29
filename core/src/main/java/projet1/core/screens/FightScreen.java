package projet1.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

import projet1.core.Fight;
import projet1.core.HealthBar;
import projet1.core.Hero;
import projet1.core.MonsterDragon;

public class FightScreen implements Screen {

	private Sprite sprite;
	private Texture texture;
	private SpriteBatch batch;
	private BitmapFont font; 
	private Stage stage;
	private TextureAtlas buttonTexture;
	private Skin skin;
	private Table table;
	private TextButton attack;
	private HealthBar healthbar;
	private int bar;
	private Fight fight;
	private Hero hero;
	private MonsterDragon monster;
	private final float death = 0;
	
	public FightScreen(Hero hero, MonsterDragon monster){
		this.hero = hero;
		this.monster = monster;
	}


	@Override
	public void render(float arg0) {
		batch.begin();
		sprite.draw(batch);
		stage.act(arg0);
		stage.draw();
		while ((monster.getLife() > death) || (hero.getLife() > death)) {
		fight.fight(hero, monster, attack);
		fight.healthbar(hero);
		healthbar.draw(batch, bar);
		}
		batch.end();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		healthbar = new HealthBar();
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
