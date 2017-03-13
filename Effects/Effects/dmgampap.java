package Effects;

import Stats.AP;
import Stats.Stat;
import Champions.Champion;

public class dmgampap extends Effect {
	int percent;

	public dmgampap(int a, Champion owner) {
		super(owner);
		percent = a;
		super.name ="DMGAMP AP";
	}

	public Stat[] applyeffect(Stat[] dmg) {
		for (int i = 0; i < dmg.length; i++) {
			if (dmg[i] instanceof AP) {
				dmg[i].setvalue((int) (dmg[i].getvalue() * 1.1));
			}
		}

		return dmg;

	}
	
	@Override
	public void print() {
	System.out.print(name + "  " + percent + "%" + " ID: " + id);
	System.out.println();
		
	}


}
