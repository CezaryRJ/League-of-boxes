package Items;


import java.util.ArrayList;

import Champions.Champion;

public class Shop {
	
Champion owner;
ArrayList<Item> items = new ArrayList<>();



public Shop(Champion owner ){
	this.owner = owner;
	items.add(new BFsword(owner));
	items.add(new OversizedRod(owner));
	items.add(new BastardsSword(owner));
	items.add(new BoomStick(owner));
	
}
	
public Item getitem(int a){
	if(items.get(a) != null){
		if(items.get(a) instanceof BoomStick){
			return new BoomStick(owner);
		}
		if(items.get(a) instanceof BFsword){
			return new BFsword(owner);
		}
		if(items.get(a) instanceof OversizedRod){
			return new OversizedRod(owner);
		}
		if(items.get(a) instanceof BastardsSword){
			return new BastardsSword(owner);
		}
		
	}
	return null;
	

}

public void print(){
System.out.println("Shop owner: " + owner.getname());
	for(int i = 0; i< items.size();i ++){
	System.out.print(i + ") ");
		items.get(i).print();
	}System.out.println();
}
public void present(){
	
	for(int i = 0; i< items.size();i ++){
		System.out.println("****************************************************************");
		items.get(i).present();
		
	}System.out.println("****************************************************************");
	
}
public ArrayList<Item> getall(){
	return items;
}

}
	