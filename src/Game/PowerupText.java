package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PowerupText {
	int xPos;
	int yPos;
	int displayTimer;
	String text;
	Color col;
	Font font;
	
	public PowerupText(int x, int y, String text, Color col) {
		xPos = x;
		yPos = y;
		this.text = text;
		this.col = col;
		displayTimer = 0;
		font = new Font("Futura", Font.PLAIN, 12);
	}
	
	public void update() {
		displayTimer++;
	}
	
	public void draw(Graphics g) {
		g.setColor(col);
		g.drawString(text, xPos, yPos);
	}
	
}
