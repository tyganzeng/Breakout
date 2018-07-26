package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
	Paddle paddle;
	Ball ball;
	List<Brick> bricks;
	List<Powerup> powerups;
	int timer;
	
	public ObjectManager(Paddle p) {
		paddle = p;
		ball = new Ball(paddle.x, paddle.y);
		bricks = new ArrayList<Brick>();
		powerups = new ArrayList<Powerup>();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 7; j++) {
				addBrick(new Brick(j * 100 + 100, i*60 + 100, Color.BLUE, "NONE"));
			}
		}
		addBrick(new Brick(200,200,Color.BLUE, "FAST"));
		addBrick(new Brick(300,200,Color.BLUE, "SLOW"));
		addBrick(new Brick(400,200,Color.BLUE, "GROW"));
		addBrick(new Brick(500,200,Color.BLUE, "MINI"));
		addBrick(new Brick(600,200,Color.BLUE, "BOUNCE"));
		
	}
	
	public void addBrick(Brick b) {
		bricks.add(b);
	}
	
	public void update() {
		paddle.update();
		ball.update();
		for(Powerup p : powerups) {
			p.update();
		}
		timer++;
	}
	public void draw(Graphics g) {
		paddle.draw(g);
		ball.draw(g);
		for(Brick b : bricks) {
			b.draw(g);
		}
		for(Powerup p : powerups) {
			p.draw(g);
		}
	}
	
	public void checkCollision() {
		if(ball.collisionBox.intersects(paddle.collisionBox) && timer > 50) {
			timer = 0;
			ball.paddleBounce(paddle.x + paddle.width/2, paddle.y + 20);
			System.out.println(ball.angle);
		}
		try {
		for(Brick b : bricks) {
			if(ball.collisionBox.intersects(b.collisionBox)) {
				if(ball.canBounce == true) {
					if (ball.hitX > b.x && ball.hitX < (b.x + b.width)){
						ball.vertBounce();
						System.out.println("vertical hit");	
					}
					else if (ball.hitY > b.y && ball.hitY < (b.y + b.height)){
						ball.horizBounce();
						System.out.println("horizontal hit");
					} else {
						ball.cornerBounce();
						System.out.println("corner hit");
					}
				}
				dropPowerup(b);
				bricks.remove(b);
				
			}
		}
		}
		catch(Exception e) {
			
		}
		
		try {
			for(Powerup p : powerups) {
				if(paddle.collisionBox.intersects(p.collisionBox)) {
					getPowerup(p);
					powerups.remove(p);
				}
			}
			}
			catch(Exception e) {
				
			}
	}
	
	public void dropPowerup(Brick b) {
		if(b.type != "NONE") {
			powerups.add(new Powerup(b.x, b.y, b.type));
		}
	}
	
	public void getPowerup(Powerup p) {
		/*switch(p.type) {
			case "FAST" : ball.speed += 5;
			case "SLOW" : ball.speed /= 2;
			default : System.out.println("nothing happened");
		}*/
		if(p.type == "FAST"){
			ball.speed += 5;
		} else if(p.type == "SLOW") {
			ball.speed /= 2;
		} else if(p.type == "GROW") {
			paddle.width += 100;
		} else if (p.type == "MINI") {
			paddle.width -= 50;
		} else if (p.type == "BOUNCE") {
			ball.canBounce = false;
		}
		else {
			System.out.println("nothing happened");
		}
	}
}
