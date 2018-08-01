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
	List<Ball> balls;
	List<Brick> bricks;
	List<Powerup> powerups;
	int timer;
	int wordTimer;
	boolean wordDisplayed;
	
	public ObjectManager(Paddle p, int level) {
		paddle = p;
		balls = new ArrayList<Ball>();
		ball = new Ball((int) paddle.x, (int) paddle.y);
		bricks = new ArrayList<Brick>();
		powerups = new ArrayList<Powerup>();
		addBall(ball);
		wordTimer = 0;
		wordDisplayed = false;
		
		if (level == 1) {

			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < i; j++) {
					if(j == 0 || j == i -1) {
						addBrick(new Brick(j * 50, i * 20 + 100, Color.BLUE, "NONE"));
					} else {
						addBrick(new Brick(j * 50, i * 20 + 100, Color.YELLOW, "NONE"));
					}
					
				}
			}
			for (int i = 6; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if(j == 0 || j == i -1) {
						addBrick(new Brick(j * 50, -i * 20 + 360, Color.BLUE, "NONE"));
					} else {
						addBrick(new Brick(j * 50, -i * 20 + 360, Color.YELLOW, "NONE"));
					}
					
				}
			}
			
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < i; j++) {
					if(j == 0 || j == i -1) {
						addBrick(new Brick(-j * 50 + 600, i * 20 + 100, Color.BLUE, "NONE"));
					} else {
						addBrick(new Brick(-j * 50 + 600, i * 20 + 100, Color.YELLOW, "NONE"));
					}
					
				}
			}
			
			for (int i = 6; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if(j == 0 || j == i -1) {
						addBrick(new Brick(-j * 50 + 600, -i * 20 + 360, Color.BLUE, "NONE"));
					} else {
						addBrick(new Brick(-j * 50 + 600, -i * 20 + 360, Color.YELLOW, "NONE"));
					}
					
				}
			}
			// addBrick(new Brick(200,200,Color.BLUE, "EIGHT"));
			//addBrick(new Brick(400, 200, Color., "EIGHT"));
			 addBrick(new Brick(50,200,Color.ORANGE, "GROW"));
			 addBrick(new Brick(150,200,Color.PINK, "MINI"));
			 addBrick(new Brick(450,200,Color.DARK_GRAY, "BOUNCE"));
			 addBrick(new Brick(550,200,Color.BLACK, "DIVIDE"));
			 addBrick(new Brick(50,240,Color.RED, "FAST"));
			 addBrick(new Brick(150,240,Color.RED, "FAST"));
			 addBrick(new Brick(450,240,Color.GREEN, "SLOW"));
			 addBrick(new Brick(550,240,Color.GREEN, "SLOW"));
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
		} else if (level == 3) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 7; j++) {
					addBrick(new Brick(j * 50 + 100, i * 60 + 100, Color.YELLOW, "NONE"));
				}
			}
			
			
			// addBrick(new Brick(200,200,Color.BLUE, "EIGHT"));
			addBrick(new Brick(400, 200, Color.BLUE, "EIGHT"));
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
	
	public void update() {
		paddle.update();
		for(Ball b : balls) {
			b.update();
		}
		for(Powerup p : powerups) {
			p.update();
		}
		timer++;
		if(wordDisplayed) {
			wordTimer++;
		}
	}
	
	public void draw(Graphics g) {
		paddle.draw(g);
		for(Ball b : balls) {
			b.draw(g);
		}
		for(Brick b : bricks) {
			b.draw(g);
		}
		for(Powerup p : powerups) {
			p.draw(g);
		}
	}
	
	public void checkCollision() {
		try {
			for(Ball b : balls) {
				if(b.collisionBox.intersects(paddle.collisionBox) && timer > 0) {
					timer = 0;
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
						if (ba.canBounce == true) {
							if (ba.hitX > b.x && ba.hitX < (b.x + b.width)) {
								ba.vertBounce();
							} else if (ba.hitY > b.y && ba.hitY < (b.y + b.height)) {
								ba.horizBounce();
								
							} else {
								ba.cornerBounce();
							
							}
						}
						dropPowerup(b);
						bricks.remove(b);

						
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
					if(wordTimer > 300) {
						
					}
				}
			}
			}
			catch(Exception e) {
				
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
				balls.get(i).speed += 5;
			} else if (p.type == "SLOW") {
				balls.get(i).speed /= 2;
			} else if (p.type == "GROW") {
				paddle.width += 100;
			} else if (p.type == "MINI") {
				paddle.width -= 50;
			} else if (p.type == "BOUNCE") {
				balls.get(i).canBounce = false;
			} else if (p.type == "DIVIDE") {
				addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, balls.get(i).angle + 5.0));
				addBall(new Ball ((int) balls.get(i).x,(int) balls.get(i).y, balls.get(i).angle - 5.0));
			} else if (p.type == "EIGHT") {
				addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, 0.0));
				addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, 45.0));
				addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, 90.0));
				addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, 135.0));
				addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, 180.0));
				addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, 225.0));
				addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, 270.0));
				addBall(new Ball((int) balls.get(i).x, (int) balls.get(i).y, 315.0));
				
			}
			else {
				System.out.println("nothing happened");
			}
		}
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
	public boolean checkGameOver() {
		if(balls.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean checkWin() {
		if(bricks.isEmpty()) {
			return true;
		}
		return false;
	}
}
