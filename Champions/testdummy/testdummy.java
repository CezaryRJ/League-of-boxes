package testdummy;

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

public class testdummy extends Champion{
	
	 {
	      super.name = "Test Dummy";
		  
		
		 	
		  super.hpcap[0] = new HP(10000); 
		  super.currentHP[0] = new HP(10000);
		  super.hppt[0] = new HP(1000); 
		
		  
		  
		  super.mpcap[0] = new MP(10000); 
		  super.currentMP[0] = new MP(10000); 
		  super.mppt[0] =new MP(1000);
		  
		  
		  super.ad[0] = new AD(100);
		  super.adpen[0] = new ADpen(0);
		  super.ADres[0] = new ADres(0);
		  
		  
		  super.ap[0] = new AP(100);
		  super.appen[0] = new APpen(0);
		  super.APres[0] = new APres(16);
		  
		  super.lifesteal[0] = new LifeSteal(0);
		  super.spellvamp[0] = new SpellVamp(0);
		  
		 
		  super.skills = null;
		  
		  }

}
