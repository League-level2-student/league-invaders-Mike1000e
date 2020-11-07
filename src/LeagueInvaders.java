import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	GamePanel gamePanel;
	JFrame frame;
	public static final int height = 800;
	public static final int width = 500;
		public static void main (String [] args) {
		LeagueInvaders league = new LeagueInvaders();
		league.setup();
			
			
			
			
			
			
			
			
			
		}
		public LeagueInvaders(){
			 frame = new JFrame();
			 gamePanel = new GamePanel();
			
			
		}
		
		
		void setup() {
			frame.add(gamePanel);
			frame.setPreferredSize(new Dimension(width,height));
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			
			
			
			
			
		}
		
		
}
