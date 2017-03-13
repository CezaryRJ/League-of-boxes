package Skills;


import Stats.Stat;
import Champions.Champion;

public interface SkillInterface {
	void UseSkill(Champion enemy);
	Stat[] applypenres(Stat[] dmg, Champion enemy);
	
}
