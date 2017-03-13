package GUI;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Champions.Champion;
import teammgmt.Team;

public class GameGUI {
	static ImagePanel panel;
	static JFrame window;
	static Team player1;
	static Team player2;

	static MainMenu tmp;
	
	static Team currentplayer;
	static Team currentopponent;

	
	static int selected = 0;
	static int target = 0;

	static Font f = new Font("serif", Font.PLAIN, 20);
	static Font a = new Font("serif", Font.PLAIN, 100);

	// //////////////friendy
	static JLabel name = new JLabel();
	static JLabel icon = new JLabel();
	static JLabel gold = new JLabel();
	static JLabel misc = new JLabel();
	static JLabel ac = new JLabel();
	static JLabel ad = new JLabel();
	static JLabel adpen = new JLabel();
	static JLabel adres = new JLabel();
	static JLabel lsteal = new JLabel();
	static JLabel ap = new JLabel();
	static JLabel apres = new JLabel();
	static JLabel appen = new JLabel();
	static JLabel svamp = new JLabel();
	static JLabel hp = new JLabel();
	static JLabel hp2 = new JLabel();
	static JLabel acp1 = new JLabel();
	static JLabel acp = new JLabel();
	static JLabel playername = new JLabel();
	

	static JButton attack = new JButton();
	static ActionListener attackbutton;

	static JButton shop = new JButton();
	static ActionListener shopbutton;

	static JButton end = new JButton();
	static ActionListener endbutton;

	static JButton next = new JButton();
	static ActionListener nextbutton;

	static JButton right = new JButton("R");
	static ActionListener rightbutton;

	static JButton left = new JButton("L");
	static ActionListener leftbutton;

	static JButton left0 = new JButton("L");
	static ActionListener left0button;

	static JButton right0 = new JButton("R");
	static ActionListener right0button;

	static JButton attack0 = new JButton();
	static ActionListener attack0button;

	static JButton attack1 = new JButton();
	static ActionListener attack1button;

	static JButton attack2 = new JButton();
	static ActionListener attack2button;

	static JButton attack3 = new JButton();
	static ActionListener attack3button;

	static JButton back = new JButton();
	static ActionListener backbutton;
	
	static JLabel gameend = new JLabel();
	
	static JLabel victoryholder;
	static ImageIcon victory;
	
	
	static Shop shop1;
	
	/////////////Enemy
	static JLabel namee = new JLabel();
	static JLabel icone = new JLabel();
	static JLabel hp2e = new JLabel();
	static JLabel adrese = new JLabel();
	static JLabel ade = new JLabel();
	static JLabel aprese = new JLabel();
	static JLabel ape = new JLabel();
	
	

	public GameGUI(ImagePanel panel, JFrame window, Team player1, Team player2,MainMenu tmp) {
		GameGUI.panel = panel;
		GameGUI.window = window;
		GameGUI.player1 = player1;
		GameGUI.player2 = player2;
		GameGUI.tmp = tmp;
		shop1 = new Shop(window, panel);
	panel.removeAll();
	
	shopbutton = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			removeallbuttons();
			
			panel.removeAll();
			window.getContentPane().remove(panel);
			panel.removeAll();
			window.getContentPane().remove(panel);
		
			
			
			panel.updateUI();
		shop1.drawshop();
		}

	};
	shop.addActionListener(shopbutton);


	
		backbutton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}

		};
		back.addActionListener(backbutton);

		attackbutton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showattacks(currentplayer.getchamp(selected), currentopponent);
			}
		};
		attack.addActionListener(attackbutton);

		endbutton = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
					if(checkifwon()){
						showendscreen();
						
					}
					else{
				
				endturn();}

			}
		};
		end.addActionListener(endbutton);

		rightbutton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (target < 4) {
					target = target + 1;
					drawstatenemy(currentopponent);

				}

			}
		};

		right.addActionListener(rightbutton);

		leftbutton = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (target > 0) {
					target = target - 1;

					drawstatenemy(currentopponent);

				}

			}

		};

		left.addActionListener(leftbutton);

		left0button = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (selected > 0) {
					selected = selected - 1;

					drawstats(currentplayer);

				}

			}

		};

		left0.addActionListener(left0button);

		right0button = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (selected < 4) {
					selected = selected + 1;

					drawstats(currentplayer);

				}

			}

		};

		right0.addActionListener(right0button);

		attack0button = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentplayer.getchamp(selected).UseSkill(0,
						currentopponent.getchamp(target));
				drawstatenemy(currentopponent);

			}

		};
		attack0.addActionListener(attack0button);

		attack1button = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentplayer.getchamp(selected).UseSkill(1,
						player2.getchamp(target));
				drawstatenemy(currentopponent);

			}

		};

		attack1.addActionListener(attack1button);

		attack2button = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentplayer.getchamp(selected).UseSkill(2,
						player2.getchamp(target));
				drawstatenemy(currentopponent);

			}

		};

		attack2.addActionListener(attack2button);

		attack3button = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentplayer.getchamp(selected).UseSkill(3,
						player2.getchamp(target));
				drawstatenemy(currentopponent);

			}

		};
		attack3.addActionListener(attack3button);


		victory = new ImageIcon("assets/img/victory.png");
		
		victoryholder = new JLabel(victory);
	}

	
public void play() {

	panel  = new ImagePanel(new ImageIcon("assets/img/champselect.jpg").getImage());
	window.getContentPane().add(panel);
		
		currentplayer = player1;
		currentopponent = player2;
		refresh();
	}


public static void refresh(){
	panel.removeAll();
	drawstatenemy(currentopponent);
	drawstats(currentplayer);
	addmenubuttons(currentplayer);
	panel.updateUI();
	
	
}
	
	public static void endturn() {
		panel.removeAll();
		removeAll();
		if (currentplayer == player1) {
			currentplayer = player2;
			currentopponent = player1;

		} else {
			currentplayer = player1;
			currentopponent = player2;

		}

		selected = 0;

		target = 0;

		drawstatenemy(currentopponent);
		drawstats(currentplayer);
		addmenubuttons(currentplayer);
		panel.updateUI();

		
	}

	public static void removeAll() {
		attack.removeAll();
		shop.removeAll();
		end.removeAll();
		next.removeAll();
		attack0.removeAll();
		attack1.removeAll();
		attack2.removeAll();
		attack3.removeAll();

	}
	
	public static void removeallbuttons(){
		panel.remove(attack);
		panel.remove(end);
		panel.remove(next);
		panel.remove(right);
		panel.remove(left);
		panel.remove(right0);
		panel.remove(left0);
		panel.remove(shop);
	}

	public static void drawstats(Team player1) {
		int y = window.getHeight();
		int x = window.getWidth();

		int x1 = 10;
		int y1 = window.getHeight() - 210;
		
		

		name.setText(player1.getchamp(selected).getname());
		name.setFont(a);
		name.setBounds(x1, y1 - (window.getHeight() / 10), x / 2, 100);
		panel.add(name);

		icon.setIcon(player1.getchamp(selected).geticon());
		icon.setBounds(player1.getchamp(selected).getname().length() * 50, y1
				- (y / 10), 130, 130);
		panel.add(icon);

		gold.setFont(new Font("serif", Font.PLAIN, 40));
		gold.setBounds(x1, y1 - 20, x / 2, 100);
		gold.setText("|Gold: ");
		panel.add(gold);

		misc.setFont(f);
		misc.setBounds(x1, y1 + 20, x / 2, 100);
		misc.setText("|HPcap: "
				+ String.valueOf(player1.getchamp(selected).calcstat(
						player1.getchamp(selected).gethpcap())));
		panel.add(misc);

		ac.setFont(f);
		ac.setBounds(x1 + (x / 8), y1 + 20, x / 2, 100);
		ac.setText("|Action points cap: ");
		panel.add(ac);

		ad.setFont(f);
		ad.setText("|AD: "
				+ String.valueOf(player1.getchamp(selected).calcstat(
						player1.getchamp(selected).getad())));
		ad.setBounds(x1, y1 + 40, x / 2, 100);

		panel.add(ad);
		panel.updateUI();

		adpen.setFont(f);
		adpen.setBounds(x1, y1 + 60, x / 2, 100);
		adpen.setText("|ADpen: "
				+ String.valueOf(player1.getchamp(selected).calcstat(
						player1.getchamp(selected).getadpen())));
		panel.add(adpen);

		adres.setFont(f);
		adres.setBounds(x1, y1 + 80, x / 2, 100);
		adres.setText("|ADres: "
				+ String.valueOf(player1.getchamp(selected).calcstat(
						player1.getchamp(selected).getadres())));
		panel.add(adres);

		lsteal.setFont(f);
		lsteal.setBounds(x1, y1 + 100, x / 2, 100);
		lsteal.setText("|Lifesteal: "
				+ String.valueOf(player1.getchamp(selected).calcstat(
						player1.getchamp(selected).getlifesteal())));
		panel.add(lsteal);

		ap.setFont(f);
		ap.setBounds(x1 + (x / 8), y1 + 40, x / 2, 100);
		ap.setText("|AP: "
				+ String.valueOf(player1.getchamp(selected).calcstat(
						player1.getchamp(selected).getap())));
		panel.add(ap);

		apres.setFont(f);
		apres.setBounds(x1 + (x / 8), y1 + 60, x / 2, 100);
		apres.setText("|APres: "
				+ String.valueOf(player1.getchamp(selected).calcstat(
						player1.getchamp(selected).getapres())));
		panel.add(apres);

		appen.setFont(f);
		appen.setBounds(x1 + (x / 8), y1 + 80, x / 2, 100);
		appen.setText("|APpen: "
				+ String.valueOf(player1.getchamp(selected).calcstat(
						player1.getchamp(selected).getappen())));
		panel.add(appen);

		svamp.setFont(f);
		svamp.setBounds(x1 + (x / 8), y1 + 100, x / 2, 100);
		svamp.setText("|Spellvamp: "
				+ String.valueOf(player1.getchamp(selected).calcstat(
						player1.getchamp(selected).getspellvamp())));
		panel.add(svamp);

		hp.setFont(f);
		hp.setBounds((x / 2) - 100, y1 + 20, x / 2, 100);
		hp.setText("HP");
		panel.add(hp);

		hp2.setFont(a);
		hp2.setBounds((x / 2) - 200, y1 + 80, x / 2, 100);
		hp2.setText(String.valueOf(player1.getchamp(selected).calcstat(
				player1.getchamp(selected).getcurrenthp())));
		panel.add(hp2);

		acp1.setFont(f);
		acp1.setBounds((x / 2) + 200, y1 + 20, x / 2, 100);
		acp1.setText("ACP");
		panel.add(acp1);

		acp.setFont(a);
		acp.setBounds((x / 2) + 200, y1 + 80, x / 2, 100);
		acp.setText("ACP");
		panel.add(acp);

		panel.updateUI();

		playername.setText("|" + player1.getname());
		playername.setFont(new Font("serif", Font.PLAIN, 40));
		playername.setBounds((x/2), y - 300, 400, 50);
		panel.add(playername);
		
		drawstatenemy(currentopponent);

	}

	public static void drawstatenemy(Team player2) {

		int x = window.getWidth();

		namee.setText(player2.getchamp(target).getname());
		namee.setBounds(x - (player2.getchamp(target).getname().length() * 48),
				0, x / 2, 100);
		namee.setFont(a);
		panel.add(namee);

		icone.setIcon(player2.getchamp(target).geticon());
		icone.setBounds(x - player2.getchamp(target).getname().length() * 50
				- 130, 0, 130, 130);
		panel.add(icone);

		hp2e.setFont(new Font("serif", Font.PLAIN, 40));
		hp2e.setBounds(x - 200, 65, x / 2, 100);
		hp2e.setText("|HP:"
				+ String.valueOf(player2.getchamp(target).calcstat(
						player2.getchamp(target).getcurrenthp())));
		panel.add(hp2e);

		adrese.setFont(f);
		adrese.setBounds(x - 100, 100, x / 2, 100);
		adrese.setText("|ADres: "
				+ String.valueOf(player2.getchamp(target).calcstat(
						player2.getchamp(target).getadres())));
		panel.add(adrese);

		ade.setFont(f);
		ade.setBounds(x - 200, 100, x / 2, 100);
		ade.setText("|AD: "
				+ String.valueOf(player2.getchamp(target).calcstat(
						player2.getchamp(target).getad())));
		panel.add(ade);

		aprese.setFont(f);
		aprese.setBounds(x - 100, 120, x / 2, 100);
		aprese.setText("|APres: "
				+ String.valueOf(player2.getchamp(target).calcstat(
						player2.getchamp(target).getapres())));
		panel.add(aprese);

		ape.setFont(f);
		ape.setBounds(x - 200, 120, x / 2, 100);
		ape.setText("|AP: "
				+ String.valueOf(player2.getchamp(target).calcstat(
						player2.getchamp(target).getap())));
		panel.add(ape);

		panel.updateUI();

	}

	public static void addmenubuttons(Team player1) {
		int y = window.getHeight();
		int x = window.getWidth();

		attack.setText("Attack");
		attack.setBounds(x - (x / 10) * 2 - (x / 20), y - 200, (x / 10),
				(y / 15));
		panel.add(attack);

		shop.setText("Shop");
		shop.setBounds(x - (x / 10) * 2 - (x / 20) + (x / 10) + 20, y - 200,
				(x / 10), (y / 15));
		panel.add(shop);

		next.setText("Switch champ");
		next.setBounds(x - (x / 10) * 2 - (x / 20) + (x / 10) + 20, y - 200
				+ (y / 10), (x / 10), (y / 15));
		panel.add(next);

		end.setText("End turn");
		end.setBounds(x - (x / 10) * 2 - (x / 20), y - 200 + (y / 10),
				(x / 10), (y / 15));
		panel.add(end);

		right.setBounds(x - (x / 15) - 20, 200, 100, 50);
		panel.add(right);

		left.setBounds(x - (x / 15) - 170, 200, 100, 50);
		panel.add(left);

		left0.setBounds(x - (x / 15) - 170, y - 300, 100, 50);
		panel.add(left0);

		right0.setBounds(x - (x / 15) - 20, y - 300, 100, 50);
		panel.add(right0);
	}
	
	public static boolean checkifwon() {
		int counter = 0;
		for(int i = 0;i<currentopponent.getteam().length;i++){
			if(currentopponent.getchamp(i).calcstat(currentopponent.getchamp(i).getcurrenthp()) <= 0){
				counter++;
				
			}
			
		}
		if(counter == 5){
			return true;
			
		}
		return false;
	}

	public static void showendscreen(){
	
	
		gameend.setBounds(window.getWidth()/4,(window.getHeight()/2)-(window.getHeight()/4), window.getWidth(),
				window.getHeight()/4);
		gameend.setFont(new Font("serif", Font.PLAIN, 140));
		gameend.setText(currentplayer.getname() + " WON!!!");
	
		panel.add(gameend);
		
		
		removeallbuttons();
		
		JButton backtomenu = new JButton("Back to main menu");
		backtomenu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					panel.removeAll();
					window.getContentPane().remove(panel);
					panel.updateUI();
				
					tmp.drawmm();
					
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
			}
			
		});
		
	
		
		backtomenu.setBounds((window.getWidth()/2)-250,(window.getHeight()/2),500,100);
		victoryholder.setBounds(window.getWidth()/8,(window.getHeight()/8)-(window.getHeight()/4),1250,1050);
	
		panel.add(backtomenu);
		panel.add(victoryholder);
		
		
		panel.updateUI();
		

		
	}
	
	
	public static void showattacks(Champion selected, Team player2) {

		panel.remove(attack);
		panel.remove(shop);
		panel.remove(next);
		panel.remove(end);

		int y = window.getHeight();
		int x = window.getWidth();
		attack0.setBounds(x - (x / 10) * 2 - (x / 20), y - 200, (x / 10),
				(y / 15));

		attack0.setText(selected.getskillbar().getskill(0).getname());

		panel.add(attack0);
		panel.updateUI();

		attack1.setBounds(x - (x / 10) * 2 - (x / 20) + (x / 10) + 20, y - 200,
				(x / 10), (y / 15));

		attack1.setText(selected.getskillbar().getskill(1).getname());

		panel.add(attack1);
		panel.updateUI();

		attack2.setBounds(x - (x / 10) * 2 - (x / 20), y - 200 + (y / 10),
				(x / 10), (y / 15));

		attack2.setText(selected.getskillbar().getskill(2).getname());

		panel.add(attack2);
		panel.updateUI();

		attack3.setBounds(x - (x / 10) * 2 - (x / 20) + (x / 10) + 20, y - 200
				+ (y / 10), (x / 10), (y / 15));

		attack3.setText(selected.getskillbar().getskill(3).getname());

		panel.add(attack3);

		back.setBounds(x - (x / 15) - 300, y - 300, 100, 50);
		back.setText("Return");
		panel.add(back);

		panel.updateUI();

	}
	
	
	private class Battleground {
		
		
		
	}

}





