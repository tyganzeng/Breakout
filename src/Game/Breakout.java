package Game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Breakout {
	JFrame window;
	GamePanel panel;
	public final static int width = 800;
	public final static int height = 800;
	
	public Breakout() {
		window = new JFrame();
		panel = new GamePanel();
	}
	
	public void setup() {
		window.add(panel);
		window.addKeyListener(panel);
		window.setVisible(true);
		window.getContentPane().setPreferredSize(new Dimension(width, height));
        window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();
	}
	
	public static void main(String[] args) {
		Breakout game = new Breakout();
		game.setup();
	}
	
}
