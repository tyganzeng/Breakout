package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Powerup extends GameObject{

	int speed;
	String type;
	
	public Powerup(int x, int y) {
		super(x, y);
		width = 40;
		height = 40;
		type = "NONE";
		color = Color.BLACK;
		speed = 3;
		collisionBox = new Rectangle(x,y,width,height);
		// TODO Auto-generated constructor stub
	}
	public Powerup(int x, int y, String type) {
		this(x,y);
		this.type = type;
		setColor();
		System.out.println(type);
		System.out.println(color);
	}
	public void update() {
		y += speed;
		collisionBox = new Rectangle((int) x,(int) y,width,height);
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawString("P", (int) x, (int) y);
		//g.fillOval((int) x, (int) y, width, height);
	}
	
	public void setColor() {
		/*switch(type) {
		
		case "FAST" : color = Color.RED;
		case "SLOW" : color = Color.GREEN;
		default : color = Color.BLACK;
		
		}*/
		if(type == "FAST") {
			color = Color.RED;
		} else if (type == "SLOW") {
			color = Color.GREEN;
		} else if (type == "GROW") {
			color = Color.ORANGE;
		} else if (type == "MINI") {
			color = Color.PINK;
		} else if (type == "BOUNCE") {
			color = Color.DARK_GRAY;
		} else if (type == "DIVIDE") {
			color = Color.BLACK;
		} else if (type == "EIGHT") {
			color = Color.CYAN;
		}
		else {
			color = Color.BLACK;
		}
	}

}
