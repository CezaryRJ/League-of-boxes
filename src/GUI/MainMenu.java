package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu {
	static ImagePanel panel = new ImagePanel(new ImageIcon("assets/img/1.jpg").getImage());
	static JFrame frame;;
	
	
	static JButton pvp = new JButton("PvP");
	static ActionListener pvpbutton;
	
	static JButton pve = new JButton("PvE");
	static ActionListener pvebutton;
	
	static JButton score = new JButton("Score");
	static ActionListener scorebutton;
	
	static JButton settings = new JButton("Settings");
	static ActionListener settingsbutton;
	
	static JButton exit = new JButton("Exit");
	static ActionListener exitbutton;
	
	static JButton champs = new JButton("Champions");
	static ActionListener championsbutton;
	
	static 	JButton items = new JButton("Items");
	static ActionListener itemsbutton;
	
	
	
	
	static ImageIcon lowermenuimg;
	static JLabel lowermenuimgholder;
	MusicPlayer player = new MusicPlayer("assets/sound/1.wav");
	
	
	public MainMenu(JFrame frame) throws Exception{
		 TeamSelect select  = new TeamSelect(panel,frame,MainMenu.this);
		
		MainMenu.frame = frame;
		
		exitbutton = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			System.exit(0);	
			}
		};
		exit.addActionListener(exitbutton);
		
		
		pvpbutton = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
		
	
			panel.removeAll();
			frame.getContentPane().remove(panel);
			select.draw();
	
			
			}
			
		};
		pvp.addActionListener(pvpbutton);
		
		player.play();
		
		
	}
	
	
	
	public void drawmm() throws Exception {
	

		panel.removeAll();
	
		
		pvp.setBounds(0, 0, 300, 70);
		pve.setBounds(150, 100, 300, 70);
		score.setBounds(300, 200, 300, 70);
		settings.setBounds(450, 300, 300, 70);
		exit.setBounds(900, 600, 300, 70);
		champs.setBounds(750, 500, 300, 70);
		items.setBounds(600, 400, 300, 70);
		
		
		lowermenuimg = new ImageIcon("assets/img/stick/graves.png");
		lowermenuimgholder = new JLabel(lowermenuimg);
		lowermenuimgholder.setBounds(0,  450, 400, 450);
		
		panel.add(pvp);
		panel.add(pve);
		panel.add(score);
		panel.add(settings);
		panel.add(exit);
		panel.add(champs);
		panel.add(items);
		panel.add(lowermenuimgholder);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel); /// adds the background
		frame.setSize(1680, 1050);
		frame.setVisible(true);
		
		panel.updateUI();

	
		
		
	}

}
