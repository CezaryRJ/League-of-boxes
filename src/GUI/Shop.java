package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Shop {

	static JFrame frame;
	static ImagePanel panel;

	public Shop(JFrame frame, ImagePanel panel) {
		this.frame = frame;
		this.panel = panel;

	}

	public void drawshop() {

		panel.removeAll();
		panel.updateUI();

		panel = new ImagePanel(new ImageIcon("assets/img/frost.jpg").getImage());
		frame.getContentPane().add(panel);

		panel.updateUI();
	}

}
