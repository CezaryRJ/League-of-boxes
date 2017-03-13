package GUI;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BladeMaster.BladeMaster;
import Xerath.Xerath;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import teammgmt.Rooster;
import teammgmt.Team;

public class TeamSelect {

	static GameGUI game;
	static ImagePanel panel;
	static JFrame frame;

	static MainMenu tmp;

	static boolean choosing = true;
	// true = player1 | false = player2

	static Team player1 = new Team("Player1");

	static Team player2 = new Team("Player2");

	static Rooster champlist = new Rooster();

	static JTextField player1name = new JTextField(player1.getname());
	static JTextField player2name = new JTextField(player2.getname());

	static JLabel title = new JLabel("Select your Champions");

	static JLabel choosingplayer = new JLabel("Currently choosing: "
			+ player1.getname());

	static JButton choosebmaldemaster = new JButton();

	static ArrayList<JButton> buttons = new ArrayList<>();


	TeamSelect(ImagePanel panel, JFrame frame, MainMenu tmp) {
		this.panel = panel;
		this.frame = frame;
		this.tmp = tmp;
		game = new GameGUI(panel, frame, player1, player2, tmp);

		panel.updateUI();

	}

	static int player1y = 200;
	static int player2y = 200;

	public void reset() {
		for (int i = 0; i < player1.getteam().length; i++) {
			player1.getteam()[i] = null;
			player2.getteam()[i] = null;
		}

		player1y = 200;
		player2y = 200;

	}

	public void draw() {
		reset();

		panel.removeAll();
		panel.updateUI();
		// ///changes background
		panel = new ImagePanel(new ImageIcon("assets/img/frost.jpg").getImage());
		frame.getContentPane().add(panel);

		player1name.setBounds(10, 50, 150, 50);
		player2name.setBounds(frame.getWidth() - 160, 50, 150, 50);
		title.setBounds((frame.getWidth() / 4), 0, 1000, 150);
		title.setFont(new Font("serif", Font.PLAIN, 100));

		choosingplayer.setBounds((frame.getWidth() / 4) + 100, 100, 1000, 100);
		choosingplayer.setFont(new Font("serif", Font.PLAIN, 60));

		panel.add(choosingplayer);
		panel.add(player1name);
		panel.add(player2name);
		panel.add(title);

		drawteam();
		drawrooster();
		panel.updateUI();

	}

	public void drawteam() {

		for (int i = 0; i < player1.getteam().length; i++) {

			if (player1.getchamp(i) != null) {
				JButton champ = new JButton(player1.getchamp(i).getname());
				champ.setIcon(player1.getchamp(i).geticon());
				champ.setBounds(0, player1y, 220, 120);
				panel.add(champ);

				player1y = player1y + 150;

			}

			if (player2.getchamp(i) != null) {
				JButton champ2 = new JButton(player2.getchamp(i).getname());
				champ2.setIcon(player2.getchamp(i).geticon());
				champ2.setBounds(frame.getWidth() - 220, player2y, 220, 120);
				panel.add(champ2);
				player2y = player2y + 150;
			}
		}

		panel.updateUI();

	}

	public void drawrooster() {
		int yvalue = 250;
		for (int i = 0; i < champlist.getchamps().size(); i++) {

			JButton champ = new JButton(champlist.getchamp(i).getname());
			champ.setBounds((frame.getWidth() / 3) - 100, yvalue,
					frame.getWidth() / 2, 100);

			int index = i;

			buttons.add(champ);
			champ.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {

					if (player2.getchamp(4) == null) {

						if (choosing == true) {
							player1.addchamp(champlist.getchamp(index));
							JButton champicon = new JButton(champlist.getchamp(
									index).getname());
							champicon.setIcon(champlist.getchamp(index)
									.geticon());
							champicon.setBounds(0, player1y, 220, 120);

							panel.add(champicon);
							choosingplayer.setText("Currently choosing: "
									+ player2name.getText());
							panel.updateUI();

							player1y = player1y + 150;
							choosing = false;

						} else {
							player2.addchamp(champlist.getchamp(index));

							JButton champicon = new JButton(champlist.getchamp(
									index).getname());
							champicon.setIcon(champlist.getchamp(index)
									.geticon());
							champicon.setBounds(frame.getWidth() - 220,
									player2y, 220, 120);

							panel.add(champicon);

							choosingplayer.setText("Currently choosing: "
									+ player1name.getText());
							panel.updateUI();
							player2y = player2y + 150;

							choosing = true;

						}

					}

					if (player2.getchamp(4) != null) {
						startbutton();
					}

				}

			});

			panel.add(champ);
			yvalue = yvalue + 100;

		}

	}

	static void startbutton() {
		JButton start = new JButton();
		start.setIcon(new ImageIcon("assets/img/start.png"));
		start.setBounds((frame.getWidth() / 3) - 100, 200,
				frame.getWidth() / 2, 700);
		for (int i = 0; i < buttons.size(); i++) {
			panel.remove(buttons.get(i));

		}

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				panel.removeAll();
				frame.getContentPane().remove(panel);
				

				game.play();

			}

		});

		player1.setname(player1name.getText());
		player2.setname(player2name.getText());

		System.out.println("start");
		panel.add(start);
		panel.updateUI();

	}

}
