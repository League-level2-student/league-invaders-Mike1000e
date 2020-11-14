import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	  final int MENU = 0;
	  final int GAME = 1;
	  final int END = 2;
	  int currentState = MENU;
	  Font titleFont;
	  Timer frameDraw;
	 
	  public GamePanel() {
		  frameDraw = new Timer(1000/60,this);
		    frameDraw.start();
		  
	  }
	@Override
	
	public void paintComponent(Graphics g){
		if(currentState == MENU){
			drawMenuState(g);
		}else if(currentState == GAME){
			drawGameState(g);
		}else if(currentState == END){
			drawEndState(g);
		}
	}
	 void updateMenuState() {  
		
	 }
	 void updateGameState() {  
		 
	 }
	 void updateEndState()  {
		 
	 }
	 void drawMenuState(Graphics g) {  
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);;
		 titleFont = new Font("Arial", Font.PLAIN, 48);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("LEAGUE INVADERS", 20, 100);
		 titleFont = new Font("Arial", Font.PLAIN, 24);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("Press ENTER to start", 20, 300);
		 titleFont = new Font("Arial", Font.PLAIN, 24);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("Press SPACE for instructions", 20, 500);
	 }
	 void drawGameState(Graphics g) {  
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
	 }
	 void drawEndState(Graphics g)  {
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.width);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
	
		repaint();
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}  
	

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
