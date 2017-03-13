import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class test1 {

	public static void main(String[] args) throws IOException {
		 JFrame frame = new JFrame("Test");

		    frame.setContentPane(new JPanel() {
		        BufferedImage image = ImageIO.read(new File("xerath.png"));
		        public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            g.drawImage(image, 0, 0, 300, 300, this);
		        }
		    });

		    frame.add(new JButton("Test Button"));

		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(300, 300);
		    frame.setVisible(true);


	}

}
