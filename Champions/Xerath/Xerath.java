package Xerath;

import javax.swing.ImageIcon;

import Champions.Champion;
import Stats.AD;
import Stats.ADpen;
import Stats.ADres;
import Stats.AP;
import Stats.APpen;
import Stats.APres;
import Stats.ActionPoint;
import Stats.Gold;
import Stats.HP;
import Stats.LifeSteal;
import Stats.MP;
import Stats.SpellVamp;

public class Xerath extends Champion {
	{
		
		super.face = new ImageIcon("assets/img/Garen.gif");
		super.name = "Xerath";
		
		super.index = 1;
		super.hpcap[0] = new HP(2000);
		super.hppt[0] = new HP(50);
		super.currentHP[0] = new HP(2000);
		
		
		super.mpcap[0] = new MP(1500);
		super.currentMP[0] = new MP(1500);
		super.mppt[0] = new MP(100);
		
		
		super.ad[0] = new AD(50);
		super.adpen[0] = new ADpen(10);	
		super.ADres[0] = new ADres(40);
		
		
		super.ap[0] = new AP(600);
		super.appen[0] = new APpen(15);
		super.APres[0] = new APres(15);
		
		super.lifesteal[0] = new LifeSteal(0);
		super.spellvamp[0] = new SpellVamp(0);
	
		
		super.skills = new XerathSkills(Xerath.this);
	}

}
