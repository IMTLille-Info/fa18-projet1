package projet1.core;

public class Fight {

	private final float ratio = 1 / 100;
	private float atk, def;
	private Hero hero;
	private MonsterDragon monster;
	
	public Fight(Hero hero, MonsterDragon monster){
		this.hero  = hero;
		this.monster = monster;
	}

	public void whoAttacksFirst() {
		monster.token = monster.getSpeed() >= hero.getSpeed();
		if (monster.token){
			monsterAttack();
		}
	}

	public void monsterAttack() {		
			atk = monster.getAtk();
			def = hero.getDef() + hero.getShield().getDef();
			hero.setLife(hero.getLife() - atk + (def * ratio));
			System.out.println("hero life "+hero.getLife());
			monster.setToken(false);
		}
	public void heroAttack(){
			atk = hero.getAtk() + hero.getWeapon().getAtk() + hero.skill.getAtk();
			def = monster.getDef();
			monster.setLife(monster.getLife() - atk + (def * ratio));
			System.out.println("monster life :"+monster.getLife());
			monster.setToken(true);
		}


	public int healthbar(float life, float lifeMax) {
		int bar = 10;
		life = hero.getLife();
		lifeMax = hero.getLifeMax();
		if ((0 <= life) && (life < (0.1 * lifeMax))) {
			bar = 1;
		}
		if ((0.1 * lifeMax) <= life && (life < (0.2 * lifeMax))) {
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
		if (((0.9 * lifeMax) <= life) && (life < lifeMax)) {
			bar = 10;
		}
		return bar;
	}

}
