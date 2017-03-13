package Items;

import Effects.Effect;
import Stats.Stat;

public interface ItemInterface {
	int getprice();
	Stat[] getstat();
	int getid();
	String getname();
	void print();
	double getsellvalue();
	Effect[] geteffects();
	void desc();
	void present();
}
