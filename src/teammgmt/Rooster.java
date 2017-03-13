package teammgmt;

import java.util.ArrayList;

import BladeMaster.BladeMaster;
import Champions.Champion;
import Xerath.Xerath;

public class Rooster {
	
	public Rooster(){
		champions.add(new BladeMaster());
		champions.add(new Xerath());
	}
	ArrayList<Champion> champions = new ArrayList<>();
	
	
	public Champion getchamp(int index){
		if(index == 0){
			return new BladeMaster();
		}
		if(index == 1){
			return new Xerath();
		}
		
		else return null;
		
		
		
		
	}
	public ArrayList<Champion> getchamps(){
		return champions;
	}
}
