package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectManager {
	
	int lives;
	Paddle paddle;
	Ball ball;
	List<Ball> balls;
	List<Brick> bricks;
	List<Bullet> bullets;
	List<Powerup> powerups;
	List<PowerupText> powerupTexts;
	int timer;
	int level;
	
	public ObjectManager(Paddle p, int level) {
		lives = 3;
		paddle = p;
		balls = new ArrayList<Ball>();
		powerupTexts = new ArrayList<PowerupText>();
		ball = new Ball((int) paddle.x, (int) paddle.y);
		bricks = new ArrayList<Brick>();
		powerups = new ArrayList<Powerup>();
		bullets = new ArrayList<Bullet>();
		addBall(ball);
		System.out.println("ball added");
		this.level = level;
		
		if (level == 1) {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < i; j++) {
					if(j == 0 || j == i -1) {
						addBrick(new Brick(j * 50, i * 20 + 100, Color.BLUE, "NONE"));
					} else {
						addBrick(new Brick(j * 50, i * 20 + 100, Color.RED, "NONE"));
					}
					
				}
			}
			for (int i = 6; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if(j == 0 || j == i -1) {
						addBrick(new Brick(j * 50, -i * 20 + 360, Color.BLUE, "NONE"));
					} else {
						addBrick(new Brick(j * 50, -i * 20 + 360, Color.RED, "NONE"));
					}
					
				}
			}
			
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < i; j++) {
					if(j == 0 || j == i -1) {
						addBrick(new Brick(-j * 50 + 600, i * 20 + 100, Color.BLUE, "NONE"));
					} else {
						addBrick(new Brick(-j * 50 + 600, i * 20 + 100, Color.RED, "NONE"));
					}
					
				}
			}
			
			for (int i = 6; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if(j == 0 || j == i -1) {
						addBrick(new Brick(-j * 50 + 600, -i * 20 + 360, Color.BLUE, "NONE"));
					} else {
						addBrick(new Brick(-j * 50 + 600, -i * 20 + 360, Color.RED, "NONE"));
					}
					
				}
			}
			// addBrick(new Brick(200,200,Color.BLUE, "EIGHT"));
			//addBrick(new Brick(400, 200, Color., "EIGHT"));
			 addBrick(new Brick(50,200,Color.YELLOW, "GROW"));
			 addBrick(new Brick(150,200,Color.YELLOW, "MINI"));
			 addBrick(new Brick(450,200,Color.YELLOW, "PIERCE"));
			 addBrick(new Brick(550,200,Color.YELLOW, "DIVIDE"));
			 addBrick(new Brick(50,240,Color.YELLOW, "FAST"));
			 addBrick(new Brick(150,240,Color.YELLOW, "FAST"));
			 addBrick(new Brick(450,240,Color.YELLOW, "SLOW"));
			 addBrick(new Brick(550,240,Color.YELLOW, "SLOW"));
		} else if (level == 2) {
			for (int i = 0; i < 3; i++) {
				//addBrick(new Brick(i*50 + 250, 80, Color.BLUE, "NONE"));
			}
			for (int i = 0; i < 3; i++) {
				addBrick(new Brick(i*50 + 250, 100, Color.BLUE, "NONE"));
			}
			for (int i = 0; i < 5; i++) {
				addBrick(new Brick(i*50 + 200, 120, Color.BLUE, "NONE"));
			}
			for (int i = 0; i < 7; i++) {
				addBrick(new Brick(i*50 + 150, 140, Color.BLUE, "NONE"));
			}
			for (int i = 0; i < 9; i++) {
				addBrick(new Brick(i*50 + 100, 160, Color.BLUE, "NONE"));
			}
			for (int i = 0; i < 9; i++) {
				addBrick(new Brick(i*50 + 100, 180, Color.BLUE, "NONE"));
			}
			for (int i = 0; i < 9; i++) {
				addBrick(new Brick(i*50 + 100, 200, Color.BLUE, "NONE"));
			}
			for (int i = 0; i < 9; i++) {
				addBrick(new Brick(i*50 + 100, 220, Color.BLUE, "NONE"));
			}
			for (int i = 0; i < 9; i++) {
				addBrick(new Brick(i*50 + 100, 160, Color.BLUE, "NONE"));
			}
			for (int i = 0; i < 11; i++) {
				addBrick(new Brick(i*50 + 50, 200, Color.LIGHT_GRAY, "NONE"));
			}
			for (int i = 0; i < 11; i++) {
				addBrick(new Brick(i*50 + 50, 220, Color.GRAY, "NONE"));
			}
			for (int i = 0; i < 13; i++) {
				if(i%2 == 0) {
					addBrick(new Brick(i*50, 240, Color.GRAY, "NONE"));
				} else {
					addBrick(new Brick(i*50, 240, Color.YELLOW, "NONE"));
				}
			}
			for (int i = 0; i < 11; i++) {
				addBrick(new Brick(i*50 + 50, 260, Color.DARK_GRAY, "NONE"));
			}
			for (int i = 0; i < 9; i++) {
				addBrick(new Brick(i*50 + 100, 280, Color.DARK_GRAY, "NONE"));
				
			}
			for (int i = 0; i < 5; i++) {
				addBrick(new Brick(i*50 + 200, 300, Color.DARK_GRAY, "NONE"));
			}
			addBrick(new Brick(50, 240, Color.YELLOW, "EIGHT"));
			addBrick(new Brick(150, 240, Color.YELLOW, "FAST"));
			addBrick(new Brick(250, 240, Color.YELLOW, "DIVIDE"));
			addBrick(new Brick(350, 240, Color.YELLOW, "BLASTER"));
			addBrick(new Brick(450, 240, Color.YELLOW, "SLOW"));
			addBrick(new Brick(550, 240, Color.YELLOW, "EIGHT"));

			
			
		} else if (level == 3) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 6; j++) {
					String randType = "NONE";
					Random r = new Random();
					int rand = r.nextInt(8);
					if(rand == 0) {
						randType = "FAST";
					} else if (rand == 1) {
						randType = "SLOW";
					} else if (rand == 2) {
						randType = "GROW";
					} else if (rand == 3) {
						randType = "MINI";
					} else if (rand == 4) {
						randType = "PIERCE";
					} else if (rand == 5) {
						randType = "DIVIDE";
					} else if (rand == 6) {
						randType = "EIGHT";
					} else if (rand == 7) {
						randType = "BLASTER";
					}
					addBrick(new Brick(j * 100 + 50, i * 60 + 100, Color.YELLOW, randType));
				}
			}
			
			
			// addBrick(new Brick(200,200,Color.BLUE, "EIGHT"));
			// addBrick(new Brick(400,200,Color.BLUE, "GROW"));
			// addBrick(new Brick(500,200,Color.BLUE, "MINI"));
			// addBrick(new Brick(600,200,Color.BLUE, "BOUNCE"));
		}
	}
	
	public void addBrick(Brick b) {
		bricks.add(b);
	}
	public void addBall(Ball b) {
		balls.add(b);
	}
	public void addText(PowerupText t) {
		powerupTexts.add(t);
	}
	
	public void update() {
		paddle.update();
		for(Ball b : balls) {
			b.update();
		}
		for(Powerup p : powerups) {
			p.update();
		}
		for(PowerupText t : powerupTexts) {
			t.update();
		}
		for(Bullet b : bullets) {
			b.update();
		}
		//System.out.println(balls.get(0).x);
		timer++;
		if(timer < 20) {
		System.out.println(timer);
		}
	}
	
	public void draw(Graphics g) {
		if(level == 2 || level == 3) {
			g.setColor(Color.BLACK);
		}
		g.fillRect(0, 0, Breakout.width, Breakout.height);
		paddle.draw(g);
		g.drawString("LIVES: " + lives, 500, 100);
		for(Ball b : balls) {
			b.draw(g);
		}
		for(Brick b : bricks) {
			b.draw(g);
		}
		for(Powerup p : powerups) {
			p.draw(g);
		}
		for(PowerupText t : powerupTexts) {
			t.draw(g);
		}
		for(Bullet b : bullets) {
			b.draw(g);
		}
	}
	
	public void checkCollision() {
		try {
			for(Ball b : balls) {
				if(b.collisionBox.intersects(paddle.collisionBox) && timer > 0) {
					b.paddleBounce((int) paddle.x + paddle.width/2, (int) paddle.y + 20);
				}
			}
		}
		catch(Exception e) {
			
		}
		try {
			for (Brick b : bricks) {
				for (Ball ba : balls) {
					if (ba.collisionBox.intersects(b.collisionBox)) {
						if (ba.canBounce && timer > 5 ) {
							if (ba.hitX > b.x && ba.hitX < (b.x + b.width)) {
								ba.vertBounce();
								dropPowerup(b);
								bricks.remove(b);
							} else if (ba.hitY > b.y && ba.hitY < (b.y + b.height)) {
								ba.horizBounce();
								dropPowerup(b);
								bricks.remove(b);
							} else {
								//ba.horizBounce();
								
								ba.cornerBounce();
								dropPowerup(b);
								bricks.remove(b);
							}
							timer = 0;
						} else {
							dropPowerup(b);
							bricks.remove(b);
				
						}
					}
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
		
		try {
			for(Brick b : bricks) {
				for(Bullet bu : bullets) {
					if(bu.collisionBox.intersects(b.collisionBox)) {
						bricks.remove(b);
						dropPowerup(b);
						bullets.remove(bu);
					}
				}
			}
		}
		catch (Exception e) {
			
		}
	}
	
	public void dropPowerup(Brick b) {
		if(b.type != "NONE") {
			powerups.add(new Powerup((int) b.x, (int) b.y, b.type));
		}
	}
	
	public void getPowerup(Powerup p) {
		/*switch(p.type) {
			case "FAST" : ball.speed += 5;
			case "SLOW" : ball.speed /= 2;
			default : System.out.println("nothing happened");
		}*/
		int size = balls.size();
		for (int i = 0; i < size; i++) {
			if (p.type == "FAST") {
				balls.get(i).speed *= 1.2;
			} else if (p.type == "SLOW") {
				balls.get(i).speed *= 0.8;
			} else if (p.type == "GROW") {
				paddle.width = 200;
			} else if (p.type == "MINI") {
				paddle.width = 50;
			} else if (p.type == "PIERCE") {
				balls.get(i).canBounce = false;
			} else if (p.type == "DIVIDE") {
				addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, balls.get(i).angle + 5.0, balls.get(0).speed, balls.get(0).canBounce));
				addBall(new Ball ((int) balls.get(i).x,(int) balls.get(i).y, balls.get(i).angle - 5.0, balls.get(0).speed, balls.get(0).canBounce));
			} else if (p.type == "EIGHT") {
				for(int j = 0; j < 8; j++) {
					if(balls.get(0).canBounce) {
						addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, j* 45.0));
					} else {
						addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, j* 45.0, balls.get(i).speed, true));
					}
				}
			} else if (p.type == "BLASTER") {
				paddle.blasterMode = true;
			}
			else {
				System.out.println("nothing happened");
			}
		}
		addText(new PowerupText((int) paddle.x, (int) paddle.y, p.type, p.color));
	}
	
	public void removeBalls() {
		try {
			for (Ball b : balls) {
				if (b.isAlive == false) {
					balls.remove(b);
				}
			}
		}
		catch(Exception e) {
			
		}
	}
	
	public void removeText() {
		try {
			for (PowerupText t : powerupTexts) {
				if (t.displayTimer > 100) {
					powerupTexts.remove(t);
				}
			}
		}
		catch(Exception e) {
			
		}
	}
	public boolean checkGameOver() {
		if(balls.isEmpty()) {
			if(lives <= 1) {
				return true;
			} else {
				lives--;
				paddle.width = 100;
				addBall(new Ball((int) paddle.x, (int) paddle.y));
			}
		}
		return false;
	}
	
	public boolean checkWin() {
		if(bricks.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void fire() {
		paddle.fire(bullets);
		System.out.println("Manager: fired");
	}
}
