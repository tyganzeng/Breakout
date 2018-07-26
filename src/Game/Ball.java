package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameObject{
	
	int hitX = x + width/2;
	int hitY = y + height/2;
	int speed;
	double angle;
	boolean canBounce;
	
	public Ball(int x, int y) {
		super(x, y);
		width = 20;
		height = 20;
		color = Color.GREEN;
		speed = 10;
		angle = 50;
		canBounce = true;
		collisionBox = new Rectangle(x,y,width,height);
	}
	
	public void update() {
		collisionBox = new Rectangle(x,y,width,height);
		x += speed * Math.sin(Math.toRadians(angle));
		y -= speed * Math.cos(Math.toRadians(angle));
		hitY = y + height/2;
		hitX = x + width/2;
		if(x > Breakout.width || x < 0) {
			angle = -angle;
		}
		if(y < 0 || y > Breakout.height) {
			angle = -angle + 180;
		}
		if(angle == 0) {
			angle += 10;
			System.out.println("0 angle");
		}
		
	}
	
	public void draw(Graphics g) {
		if(canBounce == true) {
			color = Color.GREEN;
		} else {
			color = Color.RED;
		}
		g.setColor(color);
		g.fillOval(x, y, width, height);
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 5, 5);
		g.fillOval(hitX, hitY, 5, 5);
	}
	
	public void horizBounce() {
		angle = -angle;
	}
	
	public void vertBounce() {
		angle = -angle + 180;
	}
	public void cornerBounce() {
		angle = angle + 180;
	}
	public void paddleBounce(int padX, int padY) {
		try {
			angle = Math.toDegrees(Math.atan((hitX - padX) / (padY - hitY)));
		}
		catch (Exception e) {
			
		}
	}
}
