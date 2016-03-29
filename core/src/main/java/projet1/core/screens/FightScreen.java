package projet1.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import projet1.core.Fight;
import projet1.core.HealthBar;
import projet1.core.Hero;
import projet1.core.MonsterDragon;
import projet1.core.WarGame;

public class FightScreen implements Screen {

	private Sprite sprite;
	private Texture texture;
	private SpriteBatch batch;
	private BitmapFont font;
	private Stage stage;
	private TextureAtlas buttonTexture;
	private Skin skin;
	private Table table;
	private TextButton attack;/*
	private Label lifeHero;
	private LabelStyle labelHero;
	private Label lifeMonster;
	private LabelStyle labelMonster;
	private Color colorFont;*/
	private HealthBar healthbar;
	private Fight fight;
	private Hero hero;
	private MonsterDragon monster;
	private final float death = 0;
	private WarGame game;

	public FightScreen(Hero hero, MonsterDragon monster, WarGame game) {
		this.hero = hero;
		this.monster = monster;
		this.game = game;
	}

	@Override
	public void render(float arg0) {
		batch.begin();
		sprite.draw(batch);
		healthbar.draw(batch, fight.healthbar(hero.getLife(), hero.getLifeMax()));
		hero.drawFight(batch, 100, 100);
		monster.drawFight(batch, 700, 700);
		stage.act(arg0);
		healthbar.draw(batch, fight.healthbar(hero.getLife(), hero.getLifeMax()));
		hero.draw(batch);
		stage.draw();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		fight = new Fight(hero, monster);
		healthbar = new HealthBar();
		texture = new Texture("Fight/splash03.jpg");
		sprite = new Sprite(texture);
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		buttonTexture = new TextureAtlas("Fight/Skills/attackSkill.pack");
		//colorFont = new Color(0000);
		//labelHero = new LabelStyle(font, colorFont);
		//lifeHero = new Label(hero.getLife()+"/"+hero.getLifeMax(), labelHero);
		skin = new Skin(buttonTexture);
		font = new BitmapFont(Gdx.files.internal("screens/joker.fnt"), false);
		table = new Table(skin);
		TextButtonStyle style = new TextButtonStyle();
		style.up = skin.getDrawable("Attack_skill");
		style.down = skin.getDrawable("Attack_skill-clicked");
		style.font = font;
		attack = new TextButton("", style);
		if (monster.isToken()) {
			attack.setTouchable(Touchable.disabled);
		} else {
			attack.setTouchable(Touchable.enabled);
		}
		attack.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (monster.getLife() > death) {
					fight.heroAttack();
					fight.monsterAttack();
				} else {
					game.setScreen(game.gameTiledScreen);
				}
			}
		});
		//table.add(lifeHero).width(150).height(30).padBottom(100).padLeft(200);
		//table.row();
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
