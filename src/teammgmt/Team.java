package teammgmt;

import Champions.Champion;

public class Team {
	String name;
	Champion[] team = new Champion[5];
	private int apc = 10;
	private int gold = 0;
	

	public int getapc(){
		return apc;
	}
	
	public int getgold(){
		return gold;
	}

	public void setgold(int a){
		gold = a;
		
	}

	
	public Team(String name) {
		this.name = name;

	}

	public void setname(String name){
		this.name = name ;
		
	}
	
	public void addchamp(Champion a) {
		for (int i = 0; i < team.length; i++) {
			if (team[i] == null) {
				team[i] = a;
				i = team.length + 1;
			}
		}
		printteam();
	}

	public void removechamp(String name) {
		for (int i = 0; i < team.length; i++) {
			if (team[i].getname().equals(name)) {
				team[i] = null;
				i = team.length + 1;

			}
		}

	}

	public void removechamp(int index) {
		team[index] = null;

	}

	public Champion getchamp(int index) {
		return team[index];

	}

	public void print() {
		System.out.println("Tema name: " + name + "\n");
		for (Champion a : team) {
			if (a != null) {
				a.printstats();
			}
		}
	}

	public void printteam() {
		System.out.println("Team: " + name);
		for (int i = 0; i < team.length; i++) {
			if (team[i] != null) {
				System.out.print(i + ")" + team[i].getname() + "|");
			}
		}System.out.println();
	}
	public String getname(){
		return name;
	}
	
	public Champion[] getteam(){
		return team;
	}
	
}
