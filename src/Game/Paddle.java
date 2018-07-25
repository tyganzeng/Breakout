package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle extends GameObject{
	int speed;
	
	public Paddle(int x, int y) {
		super(x, y);
		width = 100;
		height = 10;
		color = Color.BLUE;
		speed = 50;
		collisionBox = new Rectangle(x,y,width,height);
	}

	public void update() {
		collisionBox = new Rectangle(x,y,width,height);
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.fillOval(x + width/2, y + 40, 5,5);
	}
	
}
