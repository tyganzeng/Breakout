package Game;

import java.awt.Color;
import java.awt.Font;
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

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseMotionListener, MouseListener{
	Timer timer;
	Paddle paddle;
	Font titleFont;
	Font normalFont;
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
	boolean gameStarted;
	public GamePanel() {
		currentState = MENU_STATE;
		paddle = new Paddle(100,700);
		level = 1;
		titleFont = new Font("Arial", Font.PLAIN, 48);
		normalFont = new Font("Lucida Sans", Font.PLAIN, 20);
		manager = new ObjectManager(paddle,level);
		timer = new Timer(1000 / 120, this);
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
		manager.removeText();
		if(manager.checkGameOver()) {
			currentState = GAME_OVER;
			
		}
		if(manager.checkWin()) {
			currentState++;
			if(level == 3) {
				currentState++;
			}
			level++;
		}
		manager.update();
		
	}
	
	public void drawMenuState(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Breakout.width, Breakout.height);
		g.setColor(Color.BLUE);
		g.setFont(titleFont);
		g.drawString("BREAKOUT", 200, 200);
		g.setFont(normalFont);
		g.drawString("Click anywhere to start", 210, 350);
		g.drawString("Press r to restart", 220, 650);
		g.drawString("Paddle is controlled by mouse", 190,500);
		
	}
	public void drawTitleState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Breakout.width, Breakout.height);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("LEVEL: " + level, 200, 200);
		g.setFont(normalFont);
		g.drawString("Click anywhere to start", 190,400);
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
		g.setFont(titleFont);
		g.drawString("GAME OVER", 200, 200);
	}
	public void drawGameWinState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Breakout.width, Breakout.height);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("YOU WIN", 200, 200);
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
			
		} 
		else if (e.getKeyCode() == KeyEvent.VK_0) {
			currentState++;
			level++;
		} else if (e.getKeyCode() == KeyEvent.VK_R) {
			currentState = MENU_STATE;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU_STATE || currentState == GAME_TITLE1 || currentState == GAME_TITLE2 || currentState == GAME_TITLE3) {
			currentState++;
			manager = new ObjectManager(paddle,level);
			paddle.width = 100;
		} else if (currentState == GAME_OVER) {
			currentState = MENU_STATE;
		}
		else {
			manager.fire();
			System.out.println("click");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(gameStarted == false) {
			gameStarted = true;
		}
		System.out.println("pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	

}
