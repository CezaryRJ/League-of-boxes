package Items;


import Stats.AP;
import Champions.Champion;
import Effects.dmgampap;

public class BoomStick extends Item{

	BoomStick(Champion owner) {
		super(owner);
		
		super.name = "BoomStick";
		super.price = 2000;
		super.bonus[0] = new AP(500);
		super.effects[0] = new dmgampap(10,owner);
	}

}
