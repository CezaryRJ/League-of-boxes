package BladeMaster;

import Champions.Champion;
import Skillbar.SkillBar;
import Stats.ActionPoint;

public class BladeMasterSkills extends SkillBar{

	public BladeMasterSkills(Champion owner) {
		super(owner);
		super.skills[0] = new BladeMaster0(owner, new ActionPoint(5));
		super.skills[1] = new BladeMaster1(owner, new ActionPoint(5));
		super.skills[2] = new BladeMaster2(owner, new ActionPoint(5));
		super.skills[3] = new BladeMaster3(owner, new ActionPoint(5));
		// TODO Auto-generated constructor stub
	}

}
