package Game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
	Paddle paddle;
	List<Brick> bricks;
	
	public ObjectManager(Paddle p) {
		paddle = p;
		bricks = new ArrayList<Brick>();
	}
	
	public void draw(Graphics g) {
		paddle.draw(g);
		
	}
}
