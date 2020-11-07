import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	  final int MENU = 0;
	  final int GAME = 1;
	  final int END = 2;
	  int currentState = MENU;
	 
	 
	  
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
			 g.setColor(Color.BLUE);
			 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);;
		}else if(currentState == GAME){
			 g.setColor(Color.BLACK);
			 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		}else if(currentState == END){
			 g.setColor(Color.RED);
			 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.width);
		}
	}
	 void updateMenuState() {  
		
	 }
	 void updateGameState() {  
		 
	 }
	 void updateEndState()  {
		 
	 }
	
}
