package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	Paddle paddle;
	final int MENU_STATE = 0;
	final int GAME_STATE1 = 1;
	final int END_STATE = 2;
	ObjectManager manager;
	int currentState;
	
	public GamePanel() {
		paddle = new Paddle(100,700);
		timer = new Timer(1000 / 60, this);
	}
	
	public void startGame() {
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		// g.fillRect(10,10,100,100);
		/*if (currentState == MENU_STATE) {
			drawMenuState(g);

		} else if (currentState == GAME_STATE) {
			drawGameState(g);

		} else if (currentState == END_STATE) {
			drawEndState(g);
		}*/
		drawGameState(g);
	}
	
	public void actionPerformed(ActionEvent e) {
		/*if (currentState == MENU_STATE) {
			updateMenuState();

		} else if (currentState == GAME_STATE) {
			updateGameState();

		} else if (currentState == END_STATE) {
			updateEndState();
		}*/
		updateGameState();
		repaint();

	}
	
	public void updateGameState() {
		/*manager.update();
		manager.manageEnemies();
		manager.purgeObjects();
		manager.checkCollision();
		if(ship.isAlive == false) {
			currentState = END_STATE;
		}*/
		paddle.update();
	}
	
	public void drawMenuState(Graphics g) {
		/*g.setColor(Color.BLUE);
		g.fillRect(0, 0, Breakout.width, Breakout.height);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 40, 200);
		g.setFont(normalFont);
		g.drawString("Press ENTER to start", 130, 350);
		g.drawString("Press SPACE for instructions", 100,500);*/
		
	}

	public void drawGameState(Graphics g) {
		/*g.setColor(Color.BLACK);
		g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.width, LeagueInvaders.height, null);
		manager.draw(g);*/
		paddle.draw(g);
	}

	public void drawEndState(Graphics g) {
		/*g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 60, 200);
		g.drawString("" + manager.getScore(), 60, 400);*/
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddle.x -= paddle.speed;
		} 
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle.x += paddle.speed;
		} 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
