import projet1.core.Creature;
import projet1.core.Hero;
import projet1.core.Skill;

public class Fight {

	private Creature monster;
	private Hero hero;
	private Skill skill;
	private final float ratio = 1 / 100;
	private final float death = 0;

	public boolean whoAttacksFirst() {
		return monster.getSpeed() <= hero.getSpeed();
	}

	public void damage() {
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

	public void fight() {
		monster.setToken(whoAttacksFirst());
		while ((monster.getLife() > death) || (hero.getLife() > death)) {
			damage();
			if (monster.isToken()) {
				monster.setToken(false);
			} else {
				monster.setToken(true);
			}
		}

	}

}
