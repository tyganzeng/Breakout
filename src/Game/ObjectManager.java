package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
	Paddle paddle;
	Ball ball;
	List<Brick> bricks;
	int timer;
	public ObjectManager(Paddle p) {
		paddle = p;
		
		ball = new Ball(paddle.x, paddle.y);
		bricks = new ArrayList<Brick>();
		addBrick(new Brick(100,100,Color.BLUE));
		
	}
	
	public void addBrick(Brick b) {
		bricks.add(b);
	}
	
	public void update() {
		paddle.update();
		ball.update();
		timer++;
	}
	public void draw(Graphics g) {
		paddle.draw(g);
		ball.draw(g);
		for(Brick b : bricks) {
			b.draw(g);
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
				if (ball.hitY > b.y && ball.hitY < (b.y + b.height)){
					ball.horizBounce();
					System.out.println("horizontal hit");
				} //else {
					//ball.cornerBounce();
					//System.out.println("corner hit");
				//}
				bricks.remove(b);
			}
		}
		}
		catch(Exception e) {
			
		}
	}
}
