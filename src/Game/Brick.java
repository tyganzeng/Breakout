package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Brick extends GameObject{

	public Brick(int x, int y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}
