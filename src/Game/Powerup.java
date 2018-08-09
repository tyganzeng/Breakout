package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Powerup extends GameObject{

	int speed;
	String type;
	String text;
	
	public Powerup(int x, int y) {
		super(x, y);
		width = 40;
		height = 40;
		type = "NONE";
		text = "N";
		color = Color.BLACK;
		speed = 2;
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
		g.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		g.drawString(text, (int) x, (int) y);
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
			text = "F";
		} else if (type == "SLOW") {
			color = Color.BLUE;
			text = "S";
		} else if (type == "GROW") {
			color = Color.ORANGE;
			text = "G";
		} else if (type == "MINI") {
			color = Color.PINK;
			text = "M";
		} else if (type == "PIERCE") {
			color = Color.DARK_GRAY;
			text = "P";
		} else if (type == "DIVIDE") {
			color = Color.BLACK;
			text = "D";
		} else if (type == "EIGHT") {
			color = Color.CYAN;
			text = "8";
		} else if (type == "BLASTER") {
			color = Color.GREEN;
			text = "B";
		}
		else {
			color = Color.BLACK;
		}
	}

}
