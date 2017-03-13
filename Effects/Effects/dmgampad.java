package Effects;

import Stats.AD;
import Stats.Stat;
import Champions.Champion;

public class dmgampad extends Effect{
	int percent;
	
	public dmgampad(int a,Champion owner){
		super(owner);
		super.name ="DMGAMP AD";
		percent = a;
		
	}
	public Stat[] applyeffect(Stat[] a) {
		for(int i = 0; i< a.length;i++){
			if(a[i] instanceof AD){
				a[i].setvalue((int) (a[i].getvalue()*1.1));
			}
		}
		return a;
	}
	@Override
	public void print() {
	System.out.print(name + "  " + percent + "%" + " ID: " + id);
	System.out.println();
		
	}
	

}