package Items;

import Champions.Champion;
import Stats.AP;

public class OversizedRod extends Item {
	OversizedRod(Champion owner) {
		super(owner);
	
		super.price = 2500;
		super.name = "OversizedRod";
		super.bonus[0] = new AP(100);
	}

}
