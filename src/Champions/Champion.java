package Champions;

import java.text.DecimalFormat;

import javax.swing.ImageIcon;

import Effects.Effect;
import Items.Item;
import Items.Shop;
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

public class Champion implements champinterface {
	protected int itemid = 0;

	protected int index = 0;
	
	boolean dead = false;

	protected ImageIcon face;

	protected String name;

	protected SkillBar skills;

	protected HP[] hpcap = new HP[50];
	protected HP[] hppt = new HP[50];
	protected HP[] currentHP = new HP[1];

	protected MP[] mpcap = new MP[50];
	protected MP[] mppt = new MP[50];
	protected MP[] currentMP = new MP[1];

	protected AD[] ad = new AD[50];
	protected ADpen[] adpen = new ADpen[50];
	protected ADres[] ADres = new ADres[50];

	protected AP[] ap = new AP[50];
	protected APpen[] appen = new APpen[50];
	protected APres[] APres = new APres[50];

	protected LifeSteal[] lifesteal = new LifeSteal[50];
	protected SpellVamp[] spellvamp = new SpellVamp[50];

	protected Item[] items = new Item[6];
	protected Effect[] effects = new Effect[50];


	public double calcADres() {
		double res = (calcstat(ADres));
		double res1 = calcstat(ADres) + 100;
		double res3 = res / res1;
		return res3 * 100;
	}

	public double calcAPres() {
		double res = (calcstat(APres));
		double res1 = calcstat(APres) + 100;
		double res3 = res / res1;
		return res3 * 100;
	}

	public double calcLifeSteal() {
		return calcstat(lifesteal) / 100;

	}

	public double calcSpellVamp() {
		return calcstat(spellvamp) / 100;

	}

	@Override
	public void printstats() {
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("Name: " + name);
		System.out.println("-------------------");

		System.out.println("-------------------");
		System.out.println("MAX Hp: " + calcstat(hpcap));
		System.out.println("HP per turn: " + calcstat(hppt));
		System.out.println("Current HP: " + calcstat(currentHP));
		System.out.println("-------------------");
		System.out.println("MAX Mp: " + calcstat(mpcap));
		System.out.println("MP per turn: " + calcstat(mppt));
		System.out.println("Current MP: " + calcstat(currentMP));
		System.out.println("-------------------");
		System.out.println("AD damage reduction: " + df.format(calcADres())
				+ " %");
		System.out.println("AP damage reduction: " + df.format(calcAPres())
				+ " %");
		System.out.println("-------------------");
		System.out.println("Ad: " + calcstat(ad));
		System.out.println("Ad penetration: " + calcstat(adpen));
		System.out.println("Ap: " + calcstat(ap));
		System.out.println("Ap penetration: " + calcstat(appen));
		System.out.println("Lifesteal: " + calcstat(lifesteal) + " %");
		System.out.println("Spellvamp: " + calcstat(spellvamp) + " %");
		System.out.println("-------------------");

	}

	public void printitems() {

		if (items[0] == null && items[1] == null && items[2] == null
				&& items[3] == null && items[4] == null && items[5] == null) {
			System.out.println("No items");
		} else {
			System.out.println("Owned items:");
			for (int i = 0; i < items.length; i++) {
				if (items[i] != null) {
					items[i].print();
					System.out.println();
				}
			}

		}
	}

	public void printall() {
		printstats();
		printitems();

		System.out.println();
	}

	
	public void applyitem(Item a) {
		addeffect(a.geteffects());
		for (int i = 0; i < a.getstat().length; i++) {
			if (a.getstat()[i] instanceof HP) {
				currentHP[0].setvalue(currentHP[0].getvalue()
						+ a.getstat()[i].getvalue());
				addstat(a.getstat()[i], hpcap);

			} else if (a.getstat()[i] instanceof ADres) {
				addstat(a.getstat()[i], ADres);

			} else if (a.getstat()[i] instanceof AP) {
				addstat(a.getstat()[i], ap);
			} else if (a.getstat()[i] instanceof APpen) {
				addstat(a.getstat()[i], appen);

			}

			else if (a.getstat()[i] instanceof APres) {
				addstat(a.getstat()[i], APres);

			} else if (a.getstat()[i] instanceof LifeSteal) {
				addstat(a.getstat()[i], lifesteal);

			} else if (a.getstat()[i] instanceof MP) {
				addstat(a.getstat()[i], mpcap);
				currentMP[0].setvalue(currentMP[0].getvalue()
						+ a.getstat()[i].getvalue());
			} else if (a.getstat()[i] instanceof SpellVamp) {
				addstat(a.getstat()[i], spellvamp);

			} else if (a.getstat()[i] instanceof AD) {
				addstat(a.getstat()[i], ad);

			} else if (a.getstat()[i] instanceof ADpen) {
				addstat(a.getstat()[i], adpen);

			}

		}
		
		

	}

	void addeffect(Effect[] a) {
		int counter = 0;
		for (int i = 0; i < effects.length; i++) {
			if (counter <= 3) {

			} else if (effects[i] == null && a[counter] != null) {
				effects[i] = a[counter];
				counter++;
			}
		}

	}

	public void removeitem(String name) {
		for (int i = 0; i < items.length; i++) {
			if (items[i].getname().equals(name)) {
				removeitem(i);
				i = items.length + 1;

			}
		}

	}

	@Override
	public void removeitem(int a) {
		int id = items[a].getid();
		for (int i = 0; i < items[a].getstat().length; i++) {
			if (items[a].getstat() != null) {
				if (items[a].getstat()[i] instanceof AD) {
					for (int x = 1; x < ad.length; x++) {
						if (ad[x] != null) {
							if (ad[x].getid() == id) {
								ad[x] = null;

							}
						}

					}

				}

				if (items[a].getstat()[i] instanceof ADpen) {
					for (int x = 1; x < adpen.length; x++) {
						if (adpen[x] != null) {
							if (adpen[x].getid() == id) {
								adpen[x] = null;

							}
						}

					}

				}

				if (items[a].getstat()[i] instanceof ADres) {
					for (int x = 1; x < ADres.length; x++) {
						if (ADres[x] != null) {
							if (ADres[x].getid() == id) {
								ADres[x] = null;

							}
						}

					}

				}

				if (items[a].getstat()[i] instanceof AP) {
					for (int x = 1; x < ap.length; x++) {
						if (ap[x] != null) {
							if (ap[x].getid() == id) {
								ap[x] = null;

							}
						}

					}

				}

				if (items[a].getstat()[i] instanceof APpen) {
					for (int x = 1; x < appen.length; x++) {
						if (appen[x] != null) {
							if (appen[x].getid() == id) {
								appen[x] = null;

							}
						}

					}

				}

				if (items[a].getstat()[i] instanceof APres) {
					for (int x = 1; x < APres.length; x++) {
						if (APres[x] != null) {
							if (APres[x].getid() == id) {
								APres[x] = null;

							}
						}

					}

				}

				if (items[a].getstat()[i] instanceof HP) {
					for (int x = 1; x < hpcap.length; x++) {
						if (hpcap[x] != null) {
							if (hpcap[x].getid() == id) {

								currentHP[0].setvalue(currentHP[0].getvalue()
										- hpcap[x].getvalue());
								hpcap[x] = null;

							}
						}

					}

				}

				if (items[a].getstat()[i] instanceof MP) {
					for (int x = 1; x < mpcap.length; x++) {
						if (mpcap[x] != null) {
							if (mpcap[x].getid() == id) {
								currentMP[0].setvalue(currentMP[0].getvalue()
										- mpcap[x].getvalue());
								mpcap[x] = null;

							}
						}

					}

				}

				if (items[a].getstat()[i] instanceof LifeSteal) {
					for (int x = 1; x < lifesteal.length; x++) {
						if (lifesteal[x] != null) {
							if (lifesteal[x].getid() == id) {
								lifesteal[x] = null;

							}
						}

					}

				}

				if (items[a].getstat()[i] instanceof SpellVamp) {
					for (int x = 1; x < spellvamp.length; x++) {
						if (spellvamp[x] != null) {
							if (spellvamp[x].getid() == id) {
								spellvamp[x] = null;

							}
						}

					}

				}

			}

		}
		for (int i = 0; i < effects.length; i++) {
			if (effects[i] != null) {
				if (items[a].getid() == effects[i].getid()) {
					effects[i] = null;
				}
			}
		}
		items[a] = null;

	}

	@Override
	public int calcstat(Stat[] a) {
		int total = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null) {
				total = (int) (total + a[i].getvalue());
			}
		}
		return total;
	}

	@Override
	public void addstat(Stat a, Stat[] b) {
		for (int i = 0; i < b.length; i++) {
			if (b[i] == null) {
				b[i] = a;
				i = b.length + 1;
			}
		}

	}

	public String getname() {
		return name;
	}

	@Override
	public void turnend() {
		if (currentHP[0].getvalue() < calcstat(hpcap)) {
			if (currentHP[0].getvalue() + calcstat(hppt) > calcstat(hpcap)) {
				currentHP[0].setvalue(calcstat(hpcap));
			} else {
				currentHP[0].setvalue(currentHP[0].getvalue() + calcstat(hppt));

			}
		}

		if (currentMP[0].getvalue() < calcstat(mpcap)) {
			if (currentMP[0].getvalue() + calcstat(mppt) > calcstat(mpcap)) {
				currentMP[0].setvalue(calcstat(mpcap));

			} else {
				currentMP[0].setvalue(currentMP[0].getvalue() + calcstat(mppt));

			}
		}

	}

	@Override
	public double calcAPpen() {
		double res = (calcstat(appen));
		double res1 = calcstat(appen);
		double res3 = res / res1;
		return 1 - res3;
	}

	@Override
	public double calcADpen() {
		double res = (calcstat(adpen));
		double res1 = calcstat(adpen);
		double res3 = res / res1;
		return 1 - res3;
	}

	// //////////////////////////////////////////getter, setter
	@Override
	public AD[] getad() {
		// TODO Auto-generated method stub
		return ad;
	}

	@Override
	public ADpen[] getadpen() {
		// TODO Auto-generated method stub
		return adpen;
	}

	@Override
	public ADres[] getadres() {
		// TODO Auto-generated method stub
		return ADres;
	}

	@Override
	public AP[] getap() {
		// TODO Auto-generated method stub
		return ap;
	}

	@Override
	public APpen[] getappen() {
		// TODO Auto-generated method stub
		return appen;
	}

	@Override
	public APres[] getapres() {
		// TODO Auto-generated method stub
		return APres;
	}

	@Override
	public HP[] gethpcap() {
		// TODO Auto-generated method stub
		return hpcap;
	}

	@Override
	public HP[] getcurrenthp() {
		// TODO Auto-generated method stub
		return currentHP;
	}

	@Override
	public MP[] getmpcap() {
		// TODO Auto-generated method stub
		return mpcap;
	}

	@Override
	public MP[] getcurrentmp() {
		// TODO Auto-generated method stub
		return currentMP;
	}

	@Override
	public SpellVamp[] getspellvamp() {
		// TODO Auto-generated method stub
		return spellvamp;
	}

	@Override
	public LifeSteal[] getlifesteal() {
		// TODO Auto-generated method stub
		return lifesteal;
	}

	@Override
	public void setcurrenthp(int NEWHP) {
		// TODO Auto-generated method stub
		currentHP[0].setvalue(NEWHP);

	}

	@Override
	public void setcurrentmp(int NEWMP) {
		// TODO Auto-generated method stub
		currentMP[0].setvalue(NEWMP);
	}

	@Override
	public SkillBar getskillbar() {
		// TODO Auto-generated method stub
		return skills;
	}

	@Override
	public void UseSkill(int index, Champion enemy) {

		skills.getskill(index).UseSkill(enemy);

	}

	@Override
	public void printeffects() {
		for (int i = 0; i < effects.length; i++) {
			if (effects[i] != null) {
				effects[i].print();

			}
		}

	}

	@Override
	public Champion thischamp() {
		return Champion.this;
	}

	@Override
	public Stat[] applyeffect(Stat[] a) {
		Stat[] dmg = a;
		for (int i = 0; i < effects.length; i++) {
			if (effects[i] != null) {
				dmg = effects[i].applyeffect(a);

			}
		}
		return dmg;
	}

	public Stat[] merge(Stat[] a, Stat[] b) {

		int aLen = a.length;
		int bLen = b.length;
		Stat[] c = new Stat[aLen + bLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}

	
	@Override
	public double calcres(double a) {
		if (a <= 0) {
			return 1;
		}
		double res = (100 / (100 + a));

		return res;
	}

	@Override
	public Item[] getitems() {
		// TODO Auto-generated method stub
		return items;
	}

	@Override
	public ImageIcon geticon() {
		// TODO Auto-generated method stub
		return face;
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return index;
	}

		



	
	
	
	
	

	////////////////////////////////////////////////////////////

}
