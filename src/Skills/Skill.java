package Skills;

import Stats.AD;
import Stats.AP;
import Stats.ActionPoint;
import Stats.Stat;
import Champions.Champion;

public class Skill implements SkillInterface {
	protected String name = "test";
	protected Champion owner;
	protected ActionPoint cost;

	protected Skill(Champion owner, ActionPoint cost) {
		this.owner = owner;
		this.cost = cost;

	}

	@Override
	public void UseSkill(Champion enemy) {

	}

	@Override
	public Stat[] applypenres(Stat[] dmg1, Champion enemy) {

		Stat[] dmg = copy(dmg1);
		double enemyadres = enemy.calcstat(enemy.getadres())
				- owner.calcstat(owner.getadpen());
		double enemyapres = enemy.calcstat(enemy.getapres())
				- owner.calcstat(owner.getappen());
		double newadres = owner.calcres(enemyadres);
		double newapres = owner.calcres(enemyapres);

		for (int i = 0; i < dmg.length; i++) {
			if (dmg[i] instanceof AD) {
				dmg[i].setvalue(dmg[i].getvalue() * newadres);

			} else if (dmg[i] instanceof AP) {
				dmg[i].setvalue(dmg[i].getvalue() * newapres);
			}
		}

		return dmg;

	}

	Stat[] copy(Stat[] tocopy) {
		Stat[] copy = new Stat[tocopy.length];
		for (int i = 0; i < copy.length; i++) {
			if (tocopy[i] instanceof AD) {
				copy[i] = new AD((int) tocopy[i].getvalue());

			}
			if (tocopy[i] instanceof AP) {
				copy[i] = new AP((int) tocopy[i].getvalue());

			}

		}
		return copy;
	}

	public String getname() {
		// TODO Auto-generated method stub
		return name;
	}
}