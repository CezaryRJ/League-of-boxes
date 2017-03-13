package BladeMaster;

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

public class BladeMaster extends Champion{
	
	{
		
		super.face = new ImageIcon("assets/img/Zed.gif");
	      super.name = "Blade Master";
		  
		super.index = 0;
		  super.hpcap[0] = new HP(2700); 
		  super.currentHP[0] = new HP(-2700);
		  super.hppt[0] = new HP(60); 
		
		  
		  
		  super.mpcap[0] = new MP(2000); 
		  super.currentMP[0] = new MP(2000); 
		  super.mppt[0] =new MP(20);
		  
		  
		  super.ad[0] = new AD(200);
		  super.adpen[0] = new ADpen(20);
		  super.ADres[0] = new ADres(50);
		  
		  
		  super.ap[0] = new AP(0);
		  super.appen[0] = new APpen(0);
		  super.APres[0] = new APres(00);
		  
		  super.lifesteal[0] = new LifeSteal(0);
		  super.spellvamp[0] = new SpellVamp(0);
		  
		 
		  super.skills = new BladeMasterSkills(BladeMaster.this);
		  
		  }

}
