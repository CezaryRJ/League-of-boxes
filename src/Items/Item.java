package Items;

import Champions.Champion;
import Effects.Effect;
import Stats.Stat;

public class Item implements ItemInterface{
	String name;
	int price;
	int id;
	Champion owner;
	Stat[] bonus = new Stat[3];
	Effect[] effects = new Effect[3];

	
	Item(Champion owner){
		this.owner = owner;
		
	}
	@Override
	public int getprice() {
		return price;
	
	}

	@Override
	public Stat[] getstat() {
		return bonus;
	}
	public void settid(int id){
		this.id = id;
		for(int i = 0;i<bonus.length;i++){
			if(bonus[i] != null){
			bonus[i].settid(id);}
		}
		for(int i = 0;i<effects.length;i++){
			if(effects[i] != null){
				effects[i].settid(id);
			}
		}
		
	}

	@Override
	public int getid() {
	return id;
	}

	@Override
	public void print() {

	System.out.print(name);
	for(int i = 0;i<bonus.length;i++){
		if(bonus[i] != null)
		System.out.print("   "+ bonus[i].gettype()+ ": " + bonus[i].getvalue());
		}System.out.print("|   Sellvalue: " + (price * 0.65) + "  ID: " + id + "\n");
		for(int i = 0; i< effects.length;i++){
			if(effects[i] != null){
		System.out.print("Effect: ");	effects[i].print();}
		}
	}

	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double getsellvalue() {
		// TODO Auto-generated method stub
		return price*0.65;
	}

	@Override
	public Effect[] geteffects() {
		// TODO Auto-generated method stub
		return effects;
	}

	@Override
	public void desc() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void present() {

		System.out.print(name);
		for(int i = 0;i<bonus.length;i++){
			if(bonus[i] != null)
			System.out.print("   "+ bonus[i].gettype()+ ": " + bonus[i].getvalue());
			}
			for(int i = 0; i< effects.length;i++){
				if(effects[i] != null){
			System.out.print("\nEffect: ");	effects[i].print();}
			}
			System.out.println("\nPrice: " + price);
		
	}
		
	}


