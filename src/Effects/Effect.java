package Effects;

import Stats.Stat;
import Champions.Champion;

public class Effect implements EffectInterface{
	
	String name;
	Champion owner;
	int id;
Effect(Champion owner){
	this.owner = owner;
	
}
	

	@Override
	public void settid(int id) {
		this.id = id;
		
	}

	@Override
	public int getid() {
		return id;
	}

	@Override
	public Stat[] applyeffect(Stat[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void print() {
	System.out.println(name + " " + id);
		
	}
	

}
