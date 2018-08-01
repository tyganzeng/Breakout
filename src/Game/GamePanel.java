package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseMotionListener{
	Timer timer;
	Paddle paddle;
	final int MENU_STATE = 0;
	final int GAME_TITLE1 = 1;
	final int GAME_STATE1 = 2;
	final int GAME_TITLE2 = 3;
	final int GAME_STATE2 = 4;
	final int GAME_TITLE3 = 5;
	final int GAME_STATE3 = 6;
	final int GAME_OVER = 7;
	final int GAME_WIN = 8;
	ObjectManager manager;
	int currentState;
	int level;
	
	public GamePanel() {
		currentState = MENU_STATE;
		paddle = new Paddle(100,700);
		level = 1;
		manager = new ObjectManager(paddle,level);
		timer = new Timer(1000 / 100, this);
	}
	
	public void startGame() {
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		// g.fillRect(10,10,100,100);
		if (currentState == MENU_STATE) {
			drawMenuState(g);

		} else if (currentState == GAME_TITLE1 || currentState == GAME_TITLE2 || currentState == GAME_TITLE3) {
			drawTitleState(g);
		}
		else if (currentState == GAME_STATE1 || currentState == GAME_STATE2 || currentState == GAME_STATE3) {
			drawGameState(g);
			
		} else if (currentState == GAME_OVER) {
			drawGameOverState(g);
		} else if (currentState == GAME_WIN) {
			drawGameWinState(g);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU_STATE) {
			updateMenuState();

		} else if (currentState == GAME_STATE1 || currentState == GAME_STATE2 || currentState == GAME_STATE3) {
			updateGameState();

		} else if (currentState == GAME_OVER) {
			updateEndState();
		} else if (currentState == GAME_WIN) {
			//updateWinState();
		}
		repaint();

	}
	public void updateMenuState() {
		
	}
	
	public void updateEndState() {
		
	}
	public void updateGameState() {
		manager.checkCollision();
		manager.removeBalls();
		if(manager.checkGameOver()) {
			currentState = GAME_OVER;
		}
		if(manager.checkWin()) {
			currentState++;
			level++;
		}
		manager.update();
		
	}
	
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Breakout.width, Breakout.height);
		g.setColor(Color.YELLOW);
		//g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 40, 200);
		//g.setFont(normalFont);
		g.drawString("Press ENTER to start", 130, 350);
		g.drawString("Press SPACE for instructions", 100,500);
		
	}
	public void drawTitleState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Breakout.width, Breakout.height);
		g.setColor(Color.BLACK);
		//g.setFont(titleFont);
		g.drawString("LEVEL: " + level, 60, 200);
		//g.drawString("" + manager.getScore(), 60, 400);
	}
	
	public void drawGameState(Graphics g) {
		//g.setColor(Color.BLACK);
		//g.drawImage(GamePanel.spaceImg, 0, 0, Breakout.width, Breakout.height, null);
		manager.draw(g);
	}

	public void drawGameOverState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Breakout.width, Breakout.height);
		g.setColor(Color.BLACK);
		//g.setFont(titleFont);
		g.drawString("GAME OVER", 60, 200);
		//g.drawString("" + manager.getScore(), 60, 400);
	}
	public void drawGameWinState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Breakout.width, Breakout.height);
		g.setColor(Color.BLACK);
		//g.setFont(titleFont);
		g.drawString("YOU WIN", 60, 200);
		//g.drawString("" + manager.getScore(), 60, 400);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			//paddle.x -= paddle.speed;
			paddle.isMoving = true;
			paddle.direction = "LEFT";
		} 
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle.isMoving = true;
			paddle.direction = "RIGHT";
		} 
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			/*currentState++;
			if(currentState == END_STATE) {
				currentState = MENU_STATE;
			}*/
			if(currentState == MENU_STATE || currentState == GAME_TITLE1 || currentState == GAME_TITLE2 || currentState == GAME_TITLE3) {
				currentState++;
				manager = new ObjectManager(paddle,level);
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_0) {
			currentState++;
			level++;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		paddle.isMoving = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		paddle.x = e.getX();
	}

	

	

}
