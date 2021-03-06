package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick extends GameObject{

	String type;
	
	public Brick(int x, int y, Color color) {
		super(x, y, color);
		width = 50;
		height = 20;
		type = "NONE";
		collisionBox = new Rectangle(x,y,width,height);
		// TODO Auto-generated constructor stub
	}
	
	public Brick(int x, int y, Color color, String type) {
		this(x, y, color);
		this.type = type;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int) x, (int) y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect((int)x, (int) y, width, height);
	}

}
