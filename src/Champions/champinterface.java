package Champions;

import javax.swing.ImageIcon;

import Items.Item;

import Skillbar.SkillBar;
import Stats.AD;
import Stats.ADpen;
import Stats.ADres;
import Stats.AP;
import Stats.APpen;
import Stats.APres;

import Stats.HP;
import Stats.LifeSteal;
import Stats.MP;
import Stats.SpellVamp;
import Stats.Stat;

public interface champinterface {

	void applyitem(Item a);
	void removeitem(int a);
	void removeitem(String name);
	void addstat(Stat a, Stat[] b);
	void UseSkill(int index, Champion target);
	Champion thischamp();
	
	void printeffects();
	public void printstats();
	public void printitems();
	public void printall();
	int calcstat(Stat[] a);
	void turnend();
	double calcADres();
	double calcAPres();
	double calcLifeSteal();
	double calcSpellVamp();
	double calcAPpen();
	double calcADpen();
	double calcres(double a);
	
	///////////////////////////////getter
	String getname();
	public AD[] getad();
	public ADpen[] getadpen();
	public ADres[] getadres();
	public AP[] getap();
	public APpen[] getappen();
	public APres[] getapres();
	public HP[] gethpcap();
	public HP[]getcurrenthp();
	public MP[] getmpcap();
	public MP[] getcurrentmp();
	public SpellVamp[] getspellvamp();
	public LifeSteal[] getlifesteal();
	public SkillBar getskillbar();
	

	public Item[] getitems();
	
	public ImageIcon geticon();
	public int getid();

	
	///////////////////////////////setter
	public void setcurrenthp(int NEWHP);
	public void setcurrentmp(int NEWMP);
	
	

	Stat[] applyeffect(Stat[] a);
}
