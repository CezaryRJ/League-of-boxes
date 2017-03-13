package Skillbar;

import Champions.Champion;
import Skills.Skill;

public interface SkillBarInterface {

	void useSkill(int index, Champion enemy);
	public Skill getskill(int index);
	

}
