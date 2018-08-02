package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameObject{
	
	double hitX = x + width/2;
	double hitY = y + height/2;
	double speed;
	double angle;
	boolean canBounce;
	boolean isAlive;
	public Ball(int x, int y) {
		super(x, y);
		width = 20;
		height = 20;
		color = Color.GREEN;
		speed = 7;
		angle = 50;
		canBounce = true;
		isAlive = true;
		collisionBox = new Rectangle(x,y,width,height);
	}
	
	public Ball(int x, int y, double angle) {
		this(x,y);
		this.angle = angle;
	}
	public Ball(int x, int y, double angle, double speed, boolean canBounce) {
		this(x,y, angle);
		this.speed = speed;
		this.canBounce = canBounce;
	}
	
	public void update() {
		collisionBox = new Rectangle((int) x,(int) y,width,height);
		x += speed * Math.sin(Math.toRadians(angle));
		y -= speed * Math.cos(Math.toRadians(angle));
		hitY = y + height/2;
		hitX = x + width/2;
		if(x > Breakout.width || x < 0) {
			horizBounce();
		}
		if(y < 0) {
			vertBounce();
		}
		if( y > Breakout.height) {
			isAlive = false;
		}
		if(angle > 180.0) {
			angle = angle - 360.0;
		}
		if(angle < -180.0) {
			angle = angle + 360.0;
		}
		if(angle >= 80.0 && angle <= 100.0) {
			angle = 110.0;
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
		g.fillOval((int) x, (int) y, width, height);
	}
	
	public void horizBounce() {
		angle = -angle;
	}
	
	public void vertBounce() {
		angle = -angle + 180;
	}
	public void cornerBounce() {
		angle = angle + 180;
		System.out.println("corner");
	}
	public void paddleBounce(int padX, int padY) {
		try {
			angle = Math.toDegrees(Math.atan((hitX - padX) / (padY - hitY)));
		}
		catch (Exception e) {
			
		}
	}
}
