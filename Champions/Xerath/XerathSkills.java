package Xerath;

import Champions.Champion;
import Skillbar.SkillBar;
import Stats.ActionPoint;



public class XerathSkills extends SkillBar {

	public XerathSkills(Champion owner) {
		super(owner);	
		super.skills[0] = new Xerath0(owner, new ActionPoint(5));
		super.skills[1] = new Xerath1(owner,new ActionPoint(5));
		super.skills[2] = new Xerath2(owner,new ActionPoint(5));
		super.skills[3] = new Xerath3(owner,new ActionPoint(5));
	}

	

}
