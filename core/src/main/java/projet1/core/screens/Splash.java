

package projet1.core.screens;

import projet1.core.WarGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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

public class Splash implements Screen {

	private Sprite splash;
	private Texture splashTexture;
	private SpriteBatch splashBatch;
	private WarGame game;

	private BitmapFont font;
	private Stage stage;
	private TextureAtlas buttonTexture;
	private Skin skin;
	private Table table;
	private TextButton buttonplay;
	private TextButton buttonexit;
	private TextButton buttonfight;

	public Splash(WarGame game) {
		this.game = game;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		splashBatch.dispose();
		splash.getTexture().dispose();

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
	public void render(float arg0) {
		// TODO Auto-generated method stub

		splashBatch.begin();
		splash.draw(splashBatch);
		splashBatch.end();
		stage.act(arg0);
		stage.draw();


		 if (Gdx.input.isKeyPressed(Keys.ENTER)) 
             game.setScreen((Screen) game.gameTiledScreen);
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		splashBatch = new SpriteBatch();
		splashTexture = new Texture(Gdx.files.internal("splash02.png"));
		splash = new Sprite(splashTexture);
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		buttonTexture = new TextureAtlas("./screens/button.pack");
		skin = new Skin(buttonTexture);

		font = new BitmapFont(Gdx.files.internal("screens/joker.fnt"), false);

		table = new Table(skin);
		table.setBounds(150, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		TextButtonStyle style = new TextButtonStyle();
		style.up = skin.getDrawable("buttonOff");
		style.down = skin.getDrawable("buttonOn");
		style.font = font;

		buttonplay = new TextButton("Start Game", style);
		buttonplay.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.gameTiledScreen);
			}
		});

		buttonexit = new TextButton("EXIT", style);
		buttonexit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});

		buttonfight = new TextButton("FIGHT", style);
		buttonfight.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(game.fightScreen);
			}
		});

		table.add(buttonplay);
		table.row();
		table.add(buttonexit);
		table.row();
		table.add(buttonfight);
		table.debug();
		stage.addActor(table);
	}

}
