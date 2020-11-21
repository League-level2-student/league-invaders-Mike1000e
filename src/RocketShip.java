import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {

	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 30;
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g) {
		 g.setColor(Color.BLUE);
	     g.fillRect(x,y,width,height);
		
		
	}
	public void up() {
		y-=speed;
	}
	public void down( ) {
		y+=speed;
		
	}
	public void right() {
		x+=speed;
		
	}
	public void left() {
		x-=speed;
		
	}
}
