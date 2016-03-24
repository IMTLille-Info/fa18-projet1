package projet1.core;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


public class Fight {


	private final float ratio = 1 / 100;
	private final float death = 0;

	public boolean whoAttacksFirst(Hero hero, Monster monster) {
		return monster.getSpeed() <= hero.getSpeed();
	}

	public void damage(Hero hero, Monster monster, Skill skill) {
		float atk, def;
		if (monster.isToken()) {
			atk = monster.getAtk();
			def = hero.getDef() + hero.getShield().getDef();
			hero.setLife(hero.getLife() - atk + (def * ratio));
		} else {
			atk = hero.getAtk() + hero.getWeapon().getAtk() + skill.getAtk();
			def = monster.getDef();
			monster.setLife(monster.getLife() - atk + (def * ratio));
		}
	}

	public void fight(Hero hero, Monster monster, TextButton attack) {
		final Skill skill = new Skill();
		monster.setToken(whoAttacksFirst(hero, monster));
		while ((monster.getLife() > death) || (hero.getLife() > death)) {
			if (monster.isToken()) {
				
				skill.setAtk(0);
				damage(hero, monster, skill);
				monster.setToken(false);
			} else {
				attack.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				skill.setAtk(100);
			}
		});
				monster.setToken(true);
			}
		}

	}


}
