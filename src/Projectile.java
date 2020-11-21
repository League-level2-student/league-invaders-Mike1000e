
public class Projectile extends GameObject{

	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 30;
		// TODO Auto-generated constructor stub
	}
	void update(){
		y-=speed;
		
		
	}
	void draw() {
		
	}

}
