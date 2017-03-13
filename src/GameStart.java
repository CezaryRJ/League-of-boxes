import javax.swing.JFrame;

import GUI.MainMenu;


public class GameStart {

	public static void main(String[] args) throws Exception {
	MainMenu game = new MainMenu(new JFrame());
	
	/////optimize memory to only create new buttons once, not a new one every cycle(start,endscreen etc)
		
		
	game.drawmm();
	
	}

}
