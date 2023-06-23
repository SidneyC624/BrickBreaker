package BrickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -3;
	private int ballYdir = -3;
	private MapGenerator map;
	
	public Gameplay() {
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		map = new MapGenerator(3,7);
		
	}
	
	public void paint(Graphics g) {
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, 695,  558); 
		
		//bricks
		g.setColor(Color.white);
		map.draw((Graphics2D) g);
		
		//borders
		g.setColor(Color.yellow);
		g.fillRect(0,0,3,558);
		g.fillRect(0,0,695,3);
		g.fillRect(692,0,3,558);
		
		//the paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		//the ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY, 20,20);
		
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			//check ball collision with paddle
			if(new Rectangle(ballposX, ballposY, 20,20).intersects(new Rectangle(playerX,550,100,8))) {
				ballYdir = -ballYdir;
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			//check ball collision with borders
			if(ballposX < 0) {
				ballXdir = -ballXdir;
			}
			if(ballposX > 675) {
				ballXdir = -ballXdir;
			}
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX = 600;
			}
			else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX < 10) {
				playerX = 600;
			}
			else {
				moveLeft();
			}
		}
		
	}
	
	public void moveRight() {
		play = true;
		playerX += 20;
	}
	
	public void moveLeft() {
		play = true;
		playerX -= 20;
	}

	
}
