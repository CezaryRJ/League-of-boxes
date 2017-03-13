package BladeMaster;

import Champions.Champion;
import Skills.Skillad;
import Stats.AD;
import Stats.ActionPoint;
import Stats.Stat;

public class BladeMaster0 extends Skillad{

	BladeMaster0(Champion owner,ActionPoint cost) {
		super(owner, cost);
		// TODO Auto-generated constructor stub
	}
	public void UseSkill(Champion enemy){
		Stat[] damage = new Stat[50];
		AD[] ad = owner.getad();

		
		damage = owner.applyeffect(ad);
		
		damage = applypenres(damage, enemy);
		
		
		enemy.getcurrenthp()[0].setvalue(enemy.getcurrenthp()[0].getvalue() - owner.calcstat(damage));
		
	}

}
