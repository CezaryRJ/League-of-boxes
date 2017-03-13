package Items;

import Champions.Champion;
import Stats.*;

public class BFsword extends Item {
	BFsword(Champion owner) {
		super(owner);
	
		super.name = "BFsword";
		super.price = 2000;
		super.bonus[0] = new AD(50);
		super.bonus[1] = new HP(200);
	}

}
