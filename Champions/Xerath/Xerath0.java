package Xerath;

import Champions.Champion;
import Skills.Skillap;
import Stats.AP;
import Stats.ActionPoint;
import Stats.Stat;

public class Xerath0 extends Skillap {

	public Xerath0(Champion owner, ActionPoint cost) {
		super(owner, cost);
		super.name = "Pulse of magic";
	}

	public void UseSkill(Champion enemy) {

		Stat[] damage = new Stat[50];
		AP[] ap = owner.getap();
		Stat[] damage1;
		damage = owner.applyeffect(ap);
		System.out.println(enemy.calcstat(ap)+ "ap" );
		damage1 = applypenres(damage, enemy);
		
		
		System.out.println(enemy.calcstat(damage1) + "\n");
		enemy.getcurrenthp()[0].setvalue(enemy.getcurrenthp()[0].getvalue() - owner.calcstat(damage1));
	
	}

}
