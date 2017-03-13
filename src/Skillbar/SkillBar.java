package Skillbar;



import Champions.Champion;

import Skills.Skill;


public class SkillBar implements SkillBarInterface {

protected Champion owner;
	protected Skill[] skills = new Skill[4];

	public SkillBar(Champion owner){
		this.owner = owner;
		
	}

		

	@Override
	public void useSkill(int index, Champion enemy) {
		skills[index].UseSkill(enemy);

	}

	@Override
	public Skill getskill(int index) {
		// TODO Auto-generated method stub
		return skills[index];
	}
}
