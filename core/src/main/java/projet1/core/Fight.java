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
		int bar;
		monster.setToken(whoAttacksFirst(hero, monster));
		while ((monster.getLife() > death) || (hero.getLife() > death)) {
			if (monster.isToken()) {
				skill.setAtk(0);
				damage(hero, monster, skill);				
				monster.setToken(false);
			} else {
				attack.addListener(new ClickListener() {
					@Override
					public void clicked(InputEvent event, float x, float y) {
						skill.setAtk(100);
					}
				});
				damage(hero, monster, skill);
				monster.setToken(true);
			}
			bar = healthbar(hero);
		}

	}

	public int healthbar(Hero hero) {
		int bar = 10, life, lifeMax;
		life = (int) hero.getLife();
		lifeMax = (int) hero.getLifeMax();
		if ((0 <= life) && (life < (0.1 * lifeMax))) {
			bar = 1;
		}
		if ((0.1 * lifeMax)<= life && (life < (0.2 * lifeMax))) {
			bar = 2;
		}
		if ((0.2 * lifeMax <= life) && (life < (0.3 * lifeMax))) {
			bar = 3;
		}
		if (((0.3 * lifeMax) <= life) && (life < (0.4 * lifeMax))) {
			bar = 4;
		}
		if (((0.4 * lifeMax) <= life) && (life < (0.5 * lifeMax))) {
			bar = 5;
		}
		if (((0.5 * lifeMax) <= life) && (life < (0.6 * lifeMax))) {
			bar = 6;
		}
		if (((0.6 * lifeMax) <= life) && (life < (0.7 * lifeMax))) {
			bar = 7;
		}
		if (((0.7 * lifeMax) <= life) && (life < (0.8 * lifeMax))) {
			bar = 8;
		}
		if (((0.8 * lifeMax) <= life) && (life < (0.9 * lifeMax))) {
			bar = 9;
		}
		if (((0.9 * lifeMax) <= life) && (life <  lifeMax)) {
			bar = 10;
		}
		return bar;
	}

}
