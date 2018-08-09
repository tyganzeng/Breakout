package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{

	int speed;
	
	public Bullet(int x, int y) {
		super(x, y);
		width = 10;
		height = 10;
		color = Color.ORANGE;
		speed = 7;
		collisionBox = new Rectangle(x,y,width,height);
	}

	public void update() {
		y -= speed;
		collisionBox = new Rectangle((int) x,(int) y,width,height);
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int) x, (int) y, width, height);
	}
}
