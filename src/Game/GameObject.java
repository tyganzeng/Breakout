package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	double x;
	double y;
	int width;
	int height;
	Color color;
	boolean isAlive;
	Rectangle collisionBox;
	
	public GameObject(double x, double y) {
		this.x = x;
		this.y = y;
		width = 100;
		height = 100;
		isAlive = true;
		color = Color.WHITE;
		collisionBox = new Rectangle((int) x,(int) y,width,height);
	}
	
	public GameObject(int x, int y, Color col) {
		this(x,y);
		color = col;
	}
	public GameObject(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		isAlive = true;
		collisionBox = new Rectangle((int) x,(int) y,width,height);
	}
	
	public void update() {
		collisionBox.setBounds((int) x, (int) y, width, height);
	}
	
	public void draw(Graphics g) {
		
	}
}
