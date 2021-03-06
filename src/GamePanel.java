import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	  final int MENU = 0;
	  final int GAME = 1;
	  final int END = 2;
	  int currentState = MENU;
	  Font titleFont;
	  Timer frameDraw;
	  Timer alienSpawn;
	  RocketShip rocket = new RocketShip(250,700,50,50);
	  ObjectManager objectManager= new ObjectManager(rocket);
	  public static BufferedImage image;
		public static boolean needImage = true;
		public static boolean gotImage = false;	
	  public GamePanel() {
		  frameDraw = new Timer(1000/60,this);
		    frameDraw.start();
		    if (needImage) {
		        loadImage ("space.png");
		    }


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
		 objectManager.update();
		 if(rocket.isActive==false) {
			 
			 currentState=END;
		 }
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
		
		 
		 if (gotImage) {
				g.drawImage(image, 0, 0, LeagueInvaders.width, LeagueInvaders.height, null);
			} else {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
							}
		 objectManager.draw(g);

	 }
	 void drawEndState(Graphics g)  {
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		 titleFont = new Font("Arial", Font.PLAIN, 48);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("GAME OVER", 20, 100);
		 titleFont = new Font("Arial", Font.PLAIN, 24);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("You killed " +  " ememies, POG", 20, 300);
		 titleFont = new Font("Arial", Font.PLAIN, 24);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("Press ENTER to restart", 20, 500);
	 }
	 public void StartGame() {
		 alienSpawn = new Timer(1000 , objectManager);
		    alienSpawn.start();
		 
		 
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
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    }else if  (currentState == MENU) {
		        currentState = GAME;
		        StartGame();
		    } else {
		        currentState++;
		    }
		    
		}  
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			objectManager.AddProjectile(rocket.getProjectile());
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(rocket.y<720) {
				 rocket.down();
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			if(rocket.y>20) {
				 rocket.up();
			}
		  
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(rocket.x<420) {
				 rocket.right();
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(rocket.x>20) {
				 rocket.left();
			}
		}
	

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

}
