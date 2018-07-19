package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	Color color;
	boolean isAlive;
	Rectangle collisionBox;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		width = 100;
		height = 100;
		isAlive = true;
		color = Color.WHITE;
		collisionBox = new Rectangle(x,y,width,height);
	}
	public GameObject(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		isAlive = true;
		collisionBox = new Rectangle(x,y,width,height);
	}
	
	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g) {
		
	}
}
