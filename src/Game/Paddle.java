package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle extends GameObject{
	int speed;
	boolean isMoving;
	String direction;
	public Paddle(int x, int y) {
		super(x, y);
		width = 100;
		height = 10;
		color = Color.BLUE;
		speed = 10;
		isMoving = false;
		direction = "LEFT";
		collisionBox = new Rectangle(x,y,width,height);
	}

	public void update() {
		collisionBox = new Rectangle((int) x,(int) y,width,height);
		if(isMoving) {
			if(direction.equals("LEFT")) {
				x -= speed;
			} else {
				x += speed;
			}
		}
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int) x, (int) y, width, height);
	}
	
}
