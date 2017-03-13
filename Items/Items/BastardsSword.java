package Items;

import Champions.Champion;
import Effects.dmgampad;

import Stats.AD;

public class BastardsSword extends Item {

	public BastardsSword(Champion owner) {
		super(owner);
		super.owner = owner;
		super.name = "Bastards Sword";
		super.price = 3500;
		super.bonus[0] = new AD(80);
		super.effects[0] = new dmgampad(10, owner);

	}
}
