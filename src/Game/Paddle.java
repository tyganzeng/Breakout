package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends GameObject{
	int speed;
	
	public Paddle(int x, int y) {
		super(x, y);
		width = 100;
		height = 10;
		color = Color.BLUE;
		speed = 50;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
}
