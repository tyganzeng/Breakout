package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Paddle extends GameObject{
	int speed;
	boolean isMoving;
	boolean blasterMode;
	String direction;
	public Paddle(int x, int y) {
		super(x, y);
		width = 100;
		height = 10;
		color = Color.BLUE;
		speed = 10;
		isMoving = false;
		direction = "LEFT";
		blasterMode = false;
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
		if(blasterMode) {
			color = Color.RED;
			g.drawString("CLICK to fire", 100, 100);
		} else {
			color = Color.BLUE;
		}
		g.setColor(color);
		g.fillRect((int) x, (int) y, width, height);
	}
	
	public void fire(List<Bullet> bullets) {
		if(blasterMode) {
			bullets.add(new Bullet((int) x + width/8,(int) y));
			bullets.add(new Bullet((int) x + width - width/8,(int) y));
		}
	}
	
}
